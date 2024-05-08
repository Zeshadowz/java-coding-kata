package com.qburry.domain.service;

import com.qburry.domain.model.CustomerEntity;
import com.qburry.domain.model.PersonEntity;
import com.qburry.domain.repository.CustomerRepository;
import com.qburry.domain.service.mapper.CustomerMapper;
import com.qburry.domain.service.mapper.PersonMapper;
import com.qburry.web.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final PersonMapper personMapper;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(
            CustomerRepository customerRepository,
            PersonMapper personMapper,
            CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.personMapper = personMapper;
        this.customerMapper = customerMapper;
    }

    public Long save(Customer customer) {

        PersonEntity personEntity = personMapper.customerDTOToPerson(customer);

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setPerson(personEntity);
        return customerRepository.save(customerEntity).getId();
    }

    public List<Customer> findAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomer)
                .toList();
    }
}

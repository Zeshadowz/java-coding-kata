package com.qburry.service;

import com.qburry.model.CustomerEntity;
import com.qburry.model.PersonEntity;
import com.qburry.repository.CustomerRepository;
import com.qburry.service.mapper.CustomerMapper;
import com.qburry.service.mapper.PersonMapper;
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

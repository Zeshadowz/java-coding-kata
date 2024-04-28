package com.qburry.service;

import com.qburry.model.Customer;
import com.qburry.model.Person;
import com.qburry.model.PersonType;
import com.qburry.repository.CustomerRepository;
import com.qburry.service.mapper.PersonMapper;
import com.qburry.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final PersonMapper personMapper;
    private final PersonTypeService personTypeService;
    private final CustomerRepository customerRepository;

    public CustomerService(
            CustomerRepository customerRepository,
            PersonTypeService personTypeService,
            PersonMapper personMapper) {
        this.customerRepository = customerRepository;
        this.personTypeService = personTypeService;
        this.personMapper = personMapper;
    }

    public Long save(CustomerDTO customerDTO) {

        Person person = personMapper.customerDTOToPerson(customerDTO);

        PersonType type = personTypeService.getPersonTypeByName("CUSTOMER");
        /*Person person = new Person();
        person.setPersonType(type);
        person.setGender(customerDTO.getGender());
        person.setFirstname(customerDTO.getFirstName());
        person.setLastname(customerDTO.getLastName());
        person.setEmail(customerDTO.getEmail());
        person.setPhone(customerDTO.getPhone());*/
        person.setPersonType(type);

        Customer customer = new Customer();
        customer.setPerson(person);
        return customerRepository.save(customer).getId();
    }
}

package com.qburry.web;

import com.qburry.service.CustomerService;
import com.qburry.web.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    public Long createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}

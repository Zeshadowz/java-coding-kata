package com.qburry.web;

import com.qburry.domain.service.CustomerService;
import com.qburry.domain.usecase.CustomerUsecase;
import com.qburry.web.model.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerUsecase customerUsecase;

    public CustomerController(
            CustomerService customerService,
            @Qualifier("decorator") CustomerUsecase customerUsecase) {
        this.customerService = customerService;
        this.customerUsecase = customerUsecase;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }

    @PostMapping
    public Long createCustomer(@RequestBody Customer customer) {
        return customerUsecase.insertCustomer(customer);
    }
}

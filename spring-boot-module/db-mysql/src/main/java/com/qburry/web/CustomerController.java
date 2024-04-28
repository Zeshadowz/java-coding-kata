package com.qburry.web;

import com.qburry.service.CustomerService;
import com.qburry.web.model.CustomerDTO;
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
    public List<CustomerDTO> getCustomers() {
        return null;
    }

    @PostMapping
    public Long createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }
}

package com.qburry.domain.usecase.impl;

import com.qburry.domain.service.CustomerService;
import com.qburry.domain.usecase.CustomerUsecase;
import com.qburry.web.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("delegate")
public class CustomerUsecaseImpl implements CustomerUsecase {

    private final CustomerService customerService;

    public CustomerUsecaseImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public Long insertCustomer(Customer customer) {
        log.info("Delegate Inserting customer : {}", customer);
        return customerService.save(customer);
    }
}

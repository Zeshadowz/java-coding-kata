package com.qburry.domain.usecase.decorator;

import com.qburry.domain.usecase.CustomerUsecase;
import com.qburry.web.model.Customer;
import jakarta.annotation.Priority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Slf4j
@Component("decorator")
@Priority(1)
public class CustomerUsecaseDecorator implements CustomerUsecase {

    private final CustomerUsecase delegate;

    public CustomerUsecaseDecorator(@Qualifier("delegate") CustomerUsecase delegate) {
        this.delegate = delegate;
    }

    @Override
    public Long insertCustomer(Customer customer) {
        log.info("Decorator Inserting customer : {}", customer);
        return delegate.insertCustomer(customer);
    }
}

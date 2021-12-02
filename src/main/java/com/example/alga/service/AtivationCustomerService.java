package com.example.alga.service;

import com.example.alga.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class AtivationCustomerService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativar(Customer customer) {
        customer.ativar();
        eventPublisher.publishEvent(new ClienteAtivadoEvent(customer));

    }
}

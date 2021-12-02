package com.example.alga.service;

import com.example.alga.model.Customer;

public class ClienteAtivadoEvent {

    private Customer customer;

    public ClienteAtivadoEvent(Customer customer) {
        super();
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}

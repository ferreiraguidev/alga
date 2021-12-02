package com.example.alga.notficacao;

import com.example.alga.model.Customer;

public interface Notificar {

    void notificar(Customer customer, String message);
}

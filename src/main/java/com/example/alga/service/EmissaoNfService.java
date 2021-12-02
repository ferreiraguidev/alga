package com.example.alga.service;

import com.example.alga.model.Customer;
import com.example.alga.model.Product;
import com.example.alga.notficacao.Notificar;

public class EmissaoNfService {

    private Notificar notificador;

    public EmissaoNfService(Notificar notificador){
        this.notificador = notificador;
    }


    public void emitirNf(Customer customer, Product product){

        notificador.notificar(customer, " Nota Fiscal do Produto"
        +product.getNome()+"foi emitida");
    }
}

package com.example.alga.dependencyInjection;

import com.example.alga.model.Customer;
import com.example.alga.notficacao.NotificadorEmail;
import com.example.alga.notficacao.Notificar;


public class Main {

    public static void main(String[] args) {
        Customer guilherme = new Customer("Guilherme", "gfamorim@hotmail.com", "123456");
        Customer ferreiraDev = new Customer("ferreira", "ferreira@hotmail.com", "789456");

        Notificar notificar = new NotificadorEmail();


    }
}

package com.example.alga.notficacao;


import com.example.alga.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class Notificador implements Notificar{


    public void notificar(Customer customer, String message){
        System.out.printf("Notificating %s throught the  email %s : %s\n",
                customer.getName(),customer.getEmail(),message);
    }

}

package com.example.alga.notficacao;


import com.example.alga.model.Customer;
import org.springframework.stereotype.Component;

@TipoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorEmail implements Notificar {


    public void notificar(Customer customer, String message) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n"
                , customer.getName(), customer.getEmail(), message);
    }
}

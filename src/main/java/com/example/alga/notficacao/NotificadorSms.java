package com.example.alga.notficacao;

import com.example.alga.model.Customer;
import org.springframework.stereotype.Component;


@TipoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSms implements Notificar {


    public void notificar(Customer customer, String message) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
                customer.getName(), customer.getPhone(), message);
    }

}

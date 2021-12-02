package com.example.alga.listener;

import com.example.alga.service.ClienteAtivadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmissaoNFService {

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        System.out.println("emitindo nf para cliente " + event.getCustomer().getName());
    }

}

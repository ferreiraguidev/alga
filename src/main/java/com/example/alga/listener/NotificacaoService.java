package com.example.alga.listener;

import com.example.alga.notficacao.NivelUrgencia;
import com.example.alga.notficacao.Notificar;
import com.example.alga.notficacao.TipoNotificador;
import com.example.alga.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoNotificador(NivelUrgencia.NORMAL)
    @Autowired
    private Notificar notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        notificador.notificar(event.getCustomer(),"Cadastro ativo !");
    }
}

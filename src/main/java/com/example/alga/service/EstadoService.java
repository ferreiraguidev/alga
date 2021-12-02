package com.example.alga.service;

import com.example.alga.exceptions.BadRequestException;
import com.example.alga.model.Estado;
import com.example.alga.model.EstadoPostReqBody;
import com.example.alga.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;


    public List<Estado> listaEstados() {
        return estadoRepository.findAll();
    }

    public Estado findById(Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Couldn't find the correspondent id"));
    }

    public Estado salvar(EstadoPostReqBody estadoPostReqBody) {

        Estado estado = Estado.builder()
                .nome(estadoPostReqBody.getNome()).
                        build();
        return estadoRepository.save(estado);
    }

    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }

}

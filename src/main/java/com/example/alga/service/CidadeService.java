package com.example.alga.service;

import com.example.alga.exceptions.BadRequestException;
import com.example.alga.model.Cidade;
import com.example.alga.model.CidadePostReqBody;
import com.example.alga.repository.CidadeRepository;
import com.example.alga.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;


    public List<Cidade> listaEstados() {
        return cidadeRepository.findAll();
    }

    public Cidade findById(Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Couldn't find the correspondent id"));
    }

    public Cidade salvar(CidadePostReqBody cidadePostReqBody) {

        Cidade cidade = Cidade.builder()
                .nome(cidadePostReqBody.getNome())
                .estado(estadoRepository.findById(cidadePostReqBody.getEstadoId())
                        .orElseThrow(() -> new BadRequestException("NOT FOUND")))
                .build();

        return cidadeRepository.save(cidade);
    }

    public void delete(Long id) {
        cidadeRepository.deleteById(id);
    }


}

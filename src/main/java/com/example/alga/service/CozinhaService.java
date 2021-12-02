package com.example.alga.service;

import com.example.alga.exceptions.BadRequestException;
import com.example.alga.model.Cozinha;
import com.example.alga.model.CozinhaPostReqBody;
import com.example.alga.model.CozinhaPutReqBody;
import com.example.alga.repository.CozinhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {

    private final CozinhaRepository cozinhaRepository;

    public CozinhaService(CozinhaRepository cozinhaRepository) {
        this.cozinhaRepository = cozinhaRepository;
    }

    public List<Cozinha> cozinhaList() {
        return cozinhaRepository.findAll();
    }

    public Cozinha findById(Long id) {

        return cozinhaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Could not find correspondent ID"));
    }

    public Cozinha salvar(CozinhaPostReqBody cozinhaPostReqBody) {

        Cozinha cozinha = Cozinha.builder()
                .nome(cozinhaPostReqBody.getNome())
                .build();
        return cozinhaRepository.save(cozinha);
    }

    public void editar(CozinhaPutReqBody cozinhaPutReqBody) {

        Cozinha savedCozinha = findById(cozinhaPutReqBody.getId());

        Cozinha cozinha = Cozinha.builder()
                .id(savedCozinha.getId())
                .nome(savedCozinha.getNome())
                .build();

        cozinhaRepository.save(cozinha);
    }


    public void deletar(Long id) {
        cozinhaRepository.deleteById(id);
    }


}

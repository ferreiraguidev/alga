package com.example.alga.repository;

import com.example.alga.model.FormaPgto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPgtoRepository {


    List<FormaPgto> listaformaPgtos();

    FormaPgto buscarPorId(Long id);

    FormaPgto criarformaPgto(FormaPgto formaPgto);

    void excluir(FormaPgto formaPgto);

}

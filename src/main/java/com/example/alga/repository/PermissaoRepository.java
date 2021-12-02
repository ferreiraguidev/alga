package com.example.alga.repository;

import com.example.alga.model.Permissao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository {

    List<Permissao> listaPermissao();

    Permissao buscarPorId(Long id);

    Permissao criarPermissao(Permissao permissao);

    void excluir(Permissao permissao);

}

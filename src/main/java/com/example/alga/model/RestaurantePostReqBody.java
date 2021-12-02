package com.example.alga.model;

import lombok.Data;

@Data
public class RestaurantePostReqBody {

    private String nome;

    private Long taxaFrete;

    private Long cozinhaId;


}

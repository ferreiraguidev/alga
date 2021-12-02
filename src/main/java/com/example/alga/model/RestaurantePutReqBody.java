package com.example.alga.model;

import lombok.Data;

@Data
public class RestaurantePutReqBody {

    private Long id;

    private String nome;

    private Long taxaFrete;

    private Long cozinhaId;


}

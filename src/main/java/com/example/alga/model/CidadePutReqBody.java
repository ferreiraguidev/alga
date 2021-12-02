package com.example.alga.model;

import lombok.Data;

@Data
public class CidadePutReqBody {

    private Long id;

    private String nome;

    private Long estadoId;

}

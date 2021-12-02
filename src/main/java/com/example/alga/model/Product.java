package com.example.alga.model;

public class Product {

    private String nome;
    private Long valorTotal;

    public Product(String nome, Long valorTotal) {
        this.nome = nome;
        this.valorTotal = valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }
}

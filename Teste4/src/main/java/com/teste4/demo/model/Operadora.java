package com.teste4.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Operadora {

    @Id
    private Long id;
    private String nome;
    private String cnpj;
    private String municipio;

    public Operadora(Long id, String nome, String cnpj, String municipio) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.municipio = municipio;
    }
}

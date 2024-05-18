
package com.novo.prNovo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao; // Adicionando descricao

    // Construtores
    public Pergunta() {}

    public Pergunta(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }
    
    // Getters e Setters
    // id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // titulo
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

package com.atv2.plataformaPR2.model;


import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Pergunta {
    private Long id;
    private String titulo;
    private String descricao;
    private Usuario autor;
    private List<Resposta> respostas = new ArrayList<>();

    // Construtores
    public Pergunta() {
    }

    public Pergunta(String titulo, String descricao, Usuario autor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public void adicionarResposta(Resposta resposta) {
        this.respostas.add(resposta);
    }
}
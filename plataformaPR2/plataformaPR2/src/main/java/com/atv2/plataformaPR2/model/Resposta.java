
package com.atv2.plataformaPR2.model;


public class Resposta {
    private Long id;
    private String conteudo;
    private Usuario autor;
    private Pergunta pergunta;
    // outros atributos e métodos
    
    // Construtores
    public Resposta() {
    }

    public Resposta(String conteudo, Usuario autor, Pergunta pergunta) {
        this.conteudo = conteudo;
        this.autor = autor;
        this.pergunta = pergunta;
    }
    
    // Getters e Setters
    // id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // conteudo
    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    // autor
    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    // pergunta
    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}

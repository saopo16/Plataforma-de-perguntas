
package com.novo.prNovo.model;

import jakarta.persistence.*;

@Entity
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String conteudo;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Pergunta pergunta;

    // Construtores
    public Resposta() {}

    public Resposta(String conteudo, Usuario autor, Pergunta pergunta) {
        this.conteudo = conteudo;
        this.autor = autor;
        this.pergunta = pergunta;
    }

    // Getters e Setters
    // (métodos get e set)
}

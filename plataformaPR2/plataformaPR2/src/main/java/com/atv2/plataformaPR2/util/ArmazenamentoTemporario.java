
package com.atv2.plataformaPR2.util;

import com.atv2.plataformaPR2.model.Pergunta;
import com.atv2.plataformaPR2.model.Resposta;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ArmazenamentoTemporario {

    private static List<Pergunta> perguntas = new ArrayList<>();
    private static List<Resposta> respostas = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong();
    private static String nomeUsuario;

    public static List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public static void adicionarPergunta(Pergunta pergunta) {
        pergunta.setId(idCounter.incrementAndGet());
        perguntas.add(pergunta);
    }

    public static void adicionarResposta(Resposta resposta) {
    resposta.setId(idCounter.incrementAndGet());
    respostas.add(resposta);
}
    

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static void setNomeUsuario(String nome) {
        nomeUsuario = nome;
    }
}

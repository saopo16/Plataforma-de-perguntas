
package com.atv2.plataformaPR2.controller;

import com.atv2.plataformaPR2.model.Pergunta;
import com.atv2.plataformaPR2.util.ArmazenamentoTemporario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/perguntas")
    public class PerguntaController {

        // Método para exibir formulário de criação de pergunta
        @GetMapping("/criar")
        public String exibirFormularioCriacao() {
            return "criacao_pergunta"; // Supondo que haja uma página chamada "criacao_pergunta.html" no diretório de templates
        }

        // Método para criar uma nova pergunta
        @PostMapping("/criar")
public String criarPergunta(@ModelAttribute Pergunta pergunta) {
    // Adicionar a pergunta ao armazenamento temporário
    ArmazenamentoTemporario.adicionarPergunta(pergunta);
    return "redirect:/"; // Redireciona para a página inicial após a criação da pergunta
}
        // Outros métodos para manipulação de perguntas, como exibir detalhes, responder, etc.
    }

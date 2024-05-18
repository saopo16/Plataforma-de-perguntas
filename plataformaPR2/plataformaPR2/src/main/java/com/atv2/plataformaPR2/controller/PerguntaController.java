
package com.atv2.plataformaPR2.controller;


import com.atv2.plataformaPR2.model.Pergunta;
import com.atv2.plataformaPR2.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/perguntas")
public class PerguntaController {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @GetMapping("/criar")
    public String exibirFormularioCriacao() {
        return "criacao_pergunta";
    }

    @PostMapping("/criar")
    public String criarPergunta(@RequestParam String titulo, @RequestParam String descricao) {
        Pergunta pergunta = new Pergunta(titulo, descricao);
        perguntaRepository.save(pergunta);
        return "redirect:/home";
    }
}


package com.novo.prNovo.controller;


import com.novo.prNovo.model.Pergunta;
import com.novo.prNovo.model.Usuario;
import com.novo.prNovo.repository.PerguntaRepository;
import com.novo.prNovo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String criarPergunta(@RequestParam String titulo, @RequestParam String conteudo, Model model) {
        Pergunta pergunta = new Pergunta(titulo, conteudo); // Corrigindo aqui
        perguntaRepository.save(pergunta);
        return "redirect:/home";
    }
}
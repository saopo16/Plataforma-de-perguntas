
package com.novo.prNovo.controller;

import com.novo.prNovo.model.Pergunta;
import com.novo.prNovo.model.Resposta;
import com.novo.prNovo.model.Usuario;
import com.novo.prNovo.repository.PerguntaRepository;
import com.novo.prNovo.repository.RespostaRepository;
import com.novo.prNovo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("")
    public String exibirRespostas(Model model) {
        List<Pergunta> perguntas = perguntaRepository.findAll();
        model.addAttribute("perguntas", perguntas);
        return "respostas";
    }

    @GetMapping("/criar/{id}") // Corrigindo aqui
public String exibirFormularioCriacao(@PathVariable Long id, Model model) {
    Pergunta pergunta = perguntaRepository.findById(id).orElse(null);
    if (pergunta == null) {
        return "erro_pergunta_nao_encontrada";
    }
    model.addAttribute("pergunta", pergunta);
    return "criacao_resposta";
}

    @PostMapping("/criar")
    public String criarResposta(@RequestParam String conteudo, @RequestParam Long autorId, @RequestParam Long perguntaId) {
        Usuario autor = usuarioRepository.findById(autorId).orElse(null);
        Pergunta pergunta = perguntaRepository.findById(perguntaId).orElse(null);
        if (autor == null || pergunta == null) {
            return "erro_nao_encontrado";
        }
        Resposta resposta = new Resposta(conteudo, autor, pergunta);
        respostaRepository.save(resposta);
        return "redirect:/respostas";
    }
}

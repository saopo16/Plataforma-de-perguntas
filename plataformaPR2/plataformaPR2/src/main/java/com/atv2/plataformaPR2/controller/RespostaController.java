
package com.atv2.plataformaPR2.controller;



import com.atv2.plataformaPR2.model.Pergunta;
import com.atv2.plataformaPR2.model.Resposta;
import com.atv2.plataformaPR2.model.Usuario;
import com.atv2.plataformaPR2.repository.PerguntaRepository;
import com.atv2.plataformaPR2.repository.RespostaRepository;
import com.atv2.plataformaPR2.repository.UsuarioRepository;
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

    @GetMapping("/criar/{id}")
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

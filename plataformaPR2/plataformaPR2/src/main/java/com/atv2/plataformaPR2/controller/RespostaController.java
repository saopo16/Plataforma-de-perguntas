
package com.atv2.plataformaPR2.controller;

import com.atv2.plataformaPR2.model.Pergunta;
import com.atv2.plataformaPR2.model.Resposta;
import com.atv2.plataformaPR2.util.ArmazenamentoTemporario;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/respostas")
public class RespostaController {

    @GetMapping("")
    public String exibirRespostas(Model model) {
        List<Pergunta> perguntas = ArmazenamentoTemporario.getPerguntas();
        model.addAttribute("perguntas", perguntas);
        return "respostas";
    }

    @GetMapping("/criar")
public String exibirFormularioCriacao(@RequestParam("id") Long id, Model model) {
    Pergunta pergunta = ArmazenamentoTemporario.getPerguntas().stream()
        .filter(p -> p.getId().equals(id))
        .findFirst()
        .orElse(null);

    if (pergunta == null) {
        return "erro_pergunta_nao_encontrada";
    }

    model.addAttribute("pergunta", pergunta);
    model.addAttribute("respostas", pergunta.getRespostas()); // Corrigido aqui para passar as respostas corretamente
    return "criacao_resposta";
}


    @PostMapping("/criar")
public String criarResposta(@RequestParam("perguntaId") Long perguntaId, @ModelAttribute Resposta resposta) {
    Pergunta pergunta = ArmazenamentoTemporario.getPerguntas().stream()
        .filter(p -> p.getId().equals(perguntaId))
        .findFirst()
        .orElse(null);

    if (pergunta == null) {
        return "erro_pergunta_nao_encontrada";
    }

    resposta.setPergunta(pergunta);
    
    // Adiciona a resposta à pergunta
    pergunta.adicionarResposta(resposta);

    // Agora, adicione a resposta ao armazenamento temporário
    ArmazenamentoTemporario.adicionarResposta(resposta);

    return "redirect:/";
}


}


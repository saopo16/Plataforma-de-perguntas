
package com.atv2.plataformaPR2.controller;


import com.atv2.plataformaPR2.util.ArmazenamentoTemporario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Método para exibir a página inicial
    @GetMapping("/")
    public String exibirHome(Model model) {
        // Recuperar o nome do usuário do armazenamento temporário
        String nomeUsuario = ArmazenamentoTemporario.getNomeUsuario();
        // Adicionar o nome do usuário ao modelo para ser exibido na página
        model.addAttribute("nomeUsuario", nomeUsuario);
        return "home"; // Supondo que haja uma página chamada "home.html" no diretório de templates
    }
}

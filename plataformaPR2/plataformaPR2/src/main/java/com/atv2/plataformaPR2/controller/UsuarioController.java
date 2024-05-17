
package com.atv2.plataformaPR2.controller;

import com.atv2.plataformaPR2.util.ArmazenamentoTemporario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    // Método para exibir formulário de cadastro de usuário
    @GetMapping("/cadastro")
    public String exibirFormularioCadastro() {
        return "cadastro_usuario"; // Supondo que haja uma página chamada "cadastro_usuario.html" no diretório de templates
    }

    // Método para cadastrar um novo usuário
    @PostMapping("/cadastro")
    public String cadastrarUsuario(@RequestParam String nome, Model model) {
        // Salvar o nome do usuário no armazenamento temporário
        ArmazenamentoTemporario.setNomeUsuario(nome);
        return "redirect:/";
    }
}

    // Outros métodos para manipulação de usuários, como exibir perfil, editar perfil, etc.


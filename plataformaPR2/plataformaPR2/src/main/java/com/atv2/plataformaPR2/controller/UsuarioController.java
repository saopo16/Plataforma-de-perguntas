
package com.atv2.plataformaPR2.controller;


import com.atv2.plataformaPR2.model.Usuario;
import com.atv2.plataformaPR2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro() {
        return "cadastro_usuario";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        usuarioRepository.save(usuario);
        return "redirect:/home?nome=" + nome;
    }
}

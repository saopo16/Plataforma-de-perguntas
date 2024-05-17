
package com.atv2.plataformaPR2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    @GetMapping("/home")
    public String exibirHome(@RequestParam(required = false) String nome, Model model) {
        model.addAttribute("nomeUsuario", nome);
        return "home";
    }
}

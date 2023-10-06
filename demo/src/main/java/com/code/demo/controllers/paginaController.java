package com.code.demo.controllers;

import com.code.demo.models.Estante;
import com.code.demo.models.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class paginaController {

    @GetMapping("/livraria")
    public String retornarPagina(Model model){
        model.addAttribute("listaLivro", LivroController.listaLivro);


        return "livraria";


    }


}

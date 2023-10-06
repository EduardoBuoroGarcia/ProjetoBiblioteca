package com.code.demo.controllers;


import com.code.demo.models.Estante;
import com.code.demo.models.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class LivroController {
    // static

    public static ArrayList<Livro> listaLivro = new Estante().listaLivro;


    @GetMapping("/biblioteca")
    @ResponseBody
    public String pegarDadosLivro(@RequestParam(required = false) String tituloB,@RequestParam(required = false) String autor, @RequestParam(required = false) String idioma) {
        String livroEncontrado = "";
        if(autor == null){
            autor = "***";
        }
        if(tituloB == null){
            tituloB = "***";
        }
        System.out.println("Titulo para busca:" + tituloB);
        System.out.println("Autor para busca:" + autor);
                for (Livro livro : listaLivro){
                    if(livro.getTitulo().toLowerCase().contains(tituloB.toLowerCase())){
                        if(idioma != null && livro.getIdioma().toLowerCase().contains(idioma.toLowerCase())){
                            System.out.println("Encontrou! idioma");
                            livroEncontrado += "<br>LIVRO ENCONTRADO POR IDIOMA E TITULO: " +livro.toString();
                        }
                        else if (idioma == null){
                            System.out.println("Encontrou! titulo");
                            livroEncontrado += "<br>LIVRO ENCONTRADO POR TITULO: " + livro.toString();
                        }
                    }
                    else if(livro.getAutor().toLowerCase().contains(autor.toLowerCase())){
                        if(idioma == null) {
                            System.out.println("Encontrou! autor");
                            livroEncontrado += "<br> LIVRO ENCONTRADO POR AUTOR: " + livro.toString();
                        }
                        else if(livro.getIdioma().toLowerCase().contains(idioma.toLowerCase())){
                            livroEncontrado += "<br> LIVRO ENCONTRADO POR AUTOR e IDIOMA: " + livro.toString();
                        }
                    }

                }
        return livroEncontrado;
    }



    @PostMapping("/cadastroLivro")
            public String CadastrarNovoLivro(Livro livro, RedirectAttributes redirectAttributes){
                //tente fazer esse codigo.
                try{
                    Integer.parseInt(livro.getISBN());
                    Integer.parseInt(livro.getPaginas());
                    verificarString(livro.getIdioma());


                    listaLivro.add(livro);
                    redirectAttributes.addFlashAttribute("mensagem", "Livro cadastrado com sucesso!");
                    return "redirect:/livraria";

        }
        //deu erro? faz alguma coisa.
        catch (NumberFormatException e){
            redirectAttributes.addFlashAttribute("mensagem", "Erro! " + e.getMessage());
            return "redirect:/livraria";
        }
    }


// livro pode não existir
    @DeleteMapping("/deletarLivro")
    public String deletarLivro(@RequestParam int index){
        listaLivro.remove(index);
        return "Livro deletado!";
    }

    @PutMapping("/atualizarLivro/{isbn}")
    public String atualizaLivro(@PathVariable String isbn, @RequestBody Livro livro){
        try {
            Integer.parseInt(livro.getISBN());
            Integer.parseInt(livro.getPaginas());
            verificarString(livro.getIdioma());
        }catch (NumberFormatException e){
            return "Erro no cadastro verifique os dados de cadastro!!! " + e.getMessage();
        }
        for(int i = 0; i < listaLivro.size(); i++){
            //o livro que o cara mandou for igual o isbn que o cara mandou.
           if(listaLivro.get(i).getISBN().equals(isbn)){
               System.out.println("Encontrou livro para att: " + listaLivro.get(i).getTitulo());
                listaLivro.set(i,livro);
           }
        }

        return "Atualização efetuada";
    }

    public boolean  verificarString (String str){
        for(char letra : str.toCharArray()){
           if(Character.isDigit(letra)){
                throw new NumberFormatException("String contém número: " + str);
           }
            System.out.println("Não é número: " + letra);
        }
        return true;
    }

}

package com.code.demo.models;


import java.util.Date;

public class Livro {

    private String titulo;
    private String descricao;
    private String autor;
    private String paginas;
    private String idioma;
    private String ISBN;


    public Livro(String titulo, String descricao, String autor, String paginas, String idioma, String ISBN) {
        this.titulo = titulo;
        //this.titulo é o atributo da classe e o titulo sem this. e o atributo do metodo.
        this.descricao = descricao;
        this.autor = autor;
        this.paginas = paginas;
        this.idioma = idioma;
        this.ISBN = ISBN;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas='" + paginas + '\'' +
                ", idioma='" + idioma + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}

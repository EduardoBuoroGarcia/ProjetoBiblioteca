package com.code.demo;

import java.util.Scanner;

import com.code.demo.controllers.LivroController;
import com.code.demo.models.Estante;
import com.code.demo.models.Livro;
import com.code.demo.models.Microfone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;

@SpringBootApplication
public class ProjetoApplication {
    // static = Define algo que compartilha com todas as classes
    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);

        Scanner entrada = new Scanner(System.in);
        String titulo, descricao, autor, paginas, idioma, isbn;
        String i;
        while (true) {
            System.out.println("Você deseja cadastrar, deletar, atualizar ou buscar um livro? listar = mostra todos os livros ");
            i = entrada.nextLine();

            switch (i) {

                case "cadastrar":
                    System.out.println("Digite o titulo do livro: ");
                    titulo = entrada.nextLine();
                    System.out.println("Digite a descrição do livro: ");
                    descricao = entrada.nextLine();
                    System.out.println("Digite o autor do livro: ");
                    autor = entrada.nextLine();
                    System.out.println("Digite quantidade de paginas do livro: ");
                    paginas = entrada.nextLine();
                    System.out.println("Digite o idioma do livro: ");
                    idioma = entrada.nextLine();
                    System.out.println("Digite o ISBN do livro: ");
                    isbn = entrada.nextLine();
                    CadastrarLivro(titulo, descricao, autor, paginas, idioma, isbn);
                break;

                case "deletar":
                    System.out.println("Digite o ISBN do livro: ");
                    isbn = entrada.next();
                    DeletarLivro(isbn);
                break;

                case "atualizar":
                    System.out.println("Digite o ISBN do livro: ");
                    isbn = entrada.next();
                    AtualizarLivro(isbn);
                break;

                case "listar":
                    ListarLivros();
                    break;

                case "buscar":
                    String resposta;
                    System.out.println("Qual você deseja procurar titulo ou isbn: ");
                    resposta = entrada.next();
                    BuscarLivro(resposta);
                    break;
            }

        }
    }

    public static String CadastrarLivro(String titulo, String descricao, String autor, String paginas, String idioma, String isbn) {
        LivroController.listaLivro.add(new Livro(titulo, descricao, autor, paginas, idioma, isbn));
        return "Livro criado";
    }
    public static void DeletarLivro(String isbn){

        for(Livro livros: LivroController.listaLivro){
            if(livros.getISBN().equals(isbn)){
                LivroController.listaLivro.remove(livros);
                System.out.println("sucesso");
                break;
            }

        }

    }
    public static void AtualizarLivro(String isbn)
    {
        for(Livro livros: LivroController.listaLivro)
        {
            if(livros.getISBN().equals(isbn))
            {
                String a;
                Scanner entrada = new Scanner(System.in);
                System.out.println("O que você deseja atualizar? ");
                System.out.println("titulo, descricao, autor, paginas, idioma ou isbn? ");
                a = entrada.nextLine();

                switch(a){
                    case "titulo":
                        String novoTitulo;
                        System.out.println("Qual será o novo titulo? ");
                        novoTitulo = entrada.nextLine();
                        livros.setTitulo(novoTitulo);
                        break;
                    case "descricao":
                        String novaDescricao;
                        System.out.println("Qual será a nova descrição? ");
                        novaDescricao = entrada.nextLine();
                        livros.setDescricao(novaDescricao);
                        break;
                    case "autor":
                        String novoAutor;
                        System.out.println("Qual será o novo autor? ");
                        novoAutor = entrada.nextLine();
                        livros.setAutor(novoAutor);
                        break;
                    case "paginas":
                        String novaPagina;
                        System.out.println("Qual será a nova quantidade de paginas? ");
                        novaPagina = entrada.nextLine();
                        livros.setPaginas(novaPagina);
                        break;
                    case "idioma":
                        String novoIdioma;
                        System.out.println("Qual será o novo idioma? ");
                        novoIdioma = entrada.nextLine();
                        livros.setIdioma(novoIdioma);
                        break;
                    case "isbn":
                        String novoIsbn;
                        System.out.println("Qual será o novo ISBN? ");
                        novoIsbn = entrada.nextLine();
                        livros.setISBN(novoIsbn);
                        break;
                }break;

            }
        }
    }

    public static void ListarLivros(){
        for(Livro livro : LivroController.listaLivro){
            System.out.printf("%-15s : %s%n", livro.toString(), livro.toString().length());
        }

    }

    public static void BuscarLivro(String resposta){
            String isbn, titulo;
            Scanner entrada = new Scanner(System.in);
            if(resposta.equals("isbn")){
                System.out.println("Digite o ISBN do livro: ");
                isbn = entrada.nextLine();
                for(Livro livro : LivroController.listaLivro){
                    if(livro.getISBN().equals(isbn)){
                        System.out.println("Livro encontrado" + livro);
                        break;
                    }

                }
            }
            else if(resposta.equals("titulo")){
                System.out.println("Digite o titulo do livro: ");
                titulo = entrada.nextLine();
                for(Livro livro : LivroController.listaLivro){
                    if(livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                        System.out.println("Livro encontrado: " + livro);
                    }

                }
            }


    }

}



		/* // Microfone = se refere a classe Microfone; microfone2 = variavel que vai receber um tipo de classe no caso a microfone;
		// new Microfone = cria uma nova classe que recebe um ou mais atributos(depende do construtor da classe);
		Microfone microfone2 = new Microfone("LED");
		System.out.println(microfone2.corLed);
		// quando chamar um metodo de um objeto(AlterarVolume) se esse metodo tiver um valor para ser recebido só é
		// necessário inserir o valor direto(exemplo abaixo)
		microfone2.AlterarVolume(3);
		microfone2.BloquearMinhaVoz(true);
		Microfone microfone = new Microfone();
		Microfone.setNumero(5);
		System.out.println();
		String x= microfone2.toString();
	*/

/*	public String Teste(){
		// isso é uma instancia
		Estante estante = new Estante();
		// um objeto pode ser definido como uma variavel;
		Livro l1 = estante.listaLivro.get(0);
		Microfone microfone2 = new Microfone("Azul"); // Novo Microfone 1
		String S1 = microfone2.toString();
		String S2 = microfone2.corLed;
		Microfone microfone = microfone2;
		microfone.corLed = "roxo";
		microfone2 = new Microfone("Vermelho"); // Novo Microfone 2
		estante.listaLivro.add(l1);
		Livro livro = new Livro("abc", "sim", "machadinho", "50", "portugues", "325");
		estante.listaLivro.add(livro);
		estante.listaLivro.remove(livro);
		microfone.AlterarVolume(50);
		estante.listaLivro.add(new Livro("Dom Casmurro","Livro de romance Machado de Assis de 1912","Machado de Assis","123", "Portugues","77654"));
	}
	*/




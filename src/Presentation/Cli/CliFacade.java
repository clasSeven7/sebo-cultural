package Presentation.Cli;

import Domain.Entities.Livro;

import java.util.Scanner;

public class CliFacade implements Cli, OpcaoAdmin, OpcaoCliente {

    public void mostrarMenu() {
        System.out.println("<------- Bem vindo ao sistema de livraria! ------->");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Menu de opções =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - administrador");
        System.out.println("[2] - cliente");
        System.out.println("[3] - sair");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Scanner input = new Scanner(System.in);
        System.out.print(">>> ");
        int opcao = input.nextInt();

        switch (opcao) {
            case 1 -> mostrarMenuAdmin();
            case 2 -> mostrarMenuCliente();
            case 3 -> System.out.println("Saindo...");
        }
    }

    public void mostrarMenuAdmin() {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Menu do administrador =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - excluir");
        System.out.println("[2] - adicionar");
        System.out.println("[3] - cliente");
        System.out.println("[4] - voltar");
        System.out.println("[5] - sair");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Scanner inputAdmin = new Scanner(System.in);
        System.out.print(">>> ");
        int opcaoAdmin = inputAdmin.nextInt();

        switch (opcaoAdmin) {
            case 1 -> {
                System.out.println("======================================");
                System.out.println("Deseja excluir livro ou revista?");
                System.out.println("[1] - livro");
                System.out.println("[2] - revista");
                System.out.println("[3] - voltar");

                Scanner inputExcluir = new Scanner(System.in);
                System.out.print(">>> ");
                int opcaoExcluir = inputExcluir.nextInt();

                switch (opcaoExcluir) {
                    case 1 -> excluirLivro();
                    case 2 -> excluirRevista();
                    case 3 -> {
                        System.out.println("Voltando...");
                        mostrarMenuAdmin();
                    }
                }
            }
            case 2 -> {
                System.out.println("======================================");
                System.out.println("Deseja adicionar livro ou revista?");
                System.out.println("[1] - livro");
                System.out.println("[2] - revista");
                System.out.println("[3] - voltar");

                Scanner inputAdicionar = new Scanner(System.in);
                System.out.print(">>> ");
                int opcaoAdicionar = inputAdicionar.nextInt();

                switch (opcaoAdicionar) {
                    case 1 -> adicionarLivro();
                    case 2 -> adicionarRevista();
                    case 3 -> {
                        System.out.println("Voltando...");
                        mostrarMenuAdmin();
                    }
                }
            }
            case 3 -> {
                System.out.println("======================================");
                System.out.println("Deseja excluir ou adicionar cliente?");
                System.out.println("[1] - adicionar");
                System.out.println("[2] - excluir");
                System.out.println("[3] - voltar");

                Scanner inputCliente = new Scanner(System.in);
                System.out.print(">>> ");
                int opcaoCliente = inputCliente.nextInt();

                switch (opcaoCliente) {
                    case 1 -> adicionarCliente();
                    case 2 -> excluirCliente();
                    case 3 -> {
                        System.out.println("Voltando...");
                        mostrarMenuAdmin();
                    }
                }
            }
            case 4 -> {
                System.out.println("Voltando...");
                mostrarMenu();
            }
            case 5 -> System.out.println("Saindo...");
        }
    }

    public void mostrarMenuCliente() {
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Menu do cliente =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - comprar");
        System.out.println("[2] - favoritar");
        System.out.println("[3] - vender");
        System.out.println("[4] - voltar");
        System.out.println("[5] - sair");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Scanner input = new Scanner(System.in);
        System.out.print(">>> ");
        int opcao = input.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println("Deseja comprar livro ou revista?");
                System.out.println("[1] - livro");
                System.out.println("[2] - revista");
                System.out.println("[3] - voltar");

                Scanner inputComprar = new Scanner(System.in);
                System.out.print(">>> ");
                int opcaoComprar = inputComprar.nextInt();

                switch (opcaoComprar) {
                    case 1 -> comprarLivro();
                    case 2 -> comprarRevista();
                    case 3 -> {
                        System.out.println("Voltando...");
                        mostrarMenuCliente();
                    }
                }
            }
            case 2 -> {
                System.out.println("Deseja favoritar livro ou revista?");
                System.out.println("[1] - livro");
                System.out.println("[2] - revista");
                System.out.println("[3] - voltar");

                Scanner inputFavoritar = new Scanner(System.in);
                System.out.print(">>> ");
                int opcaoFavoritar = inputFavoritar.nextInt();

                switch (opcaoFavoritar) {
                    case 1 -> favoritarLivro();
                    case 2 -> favoritarRevista();
                    case 3 -> {
                        System.out.println("Voltando...");
                        mostrarMenuCliente();
                    }
                }
            }
            case 3 -> {
                System.out.println("Deseja vender livro ou revista?");
                System.out.println("[1] - livro");
                System.out.println("[2] - revista");
                System.out.println("[3] - voltar");

                Scanner inputVender = new Scanner(System.in);
                System.out.print(">>> ");
                int opcaoVender = inputVender.nextInt();

                switch (opcaoVender) {
                    case 1 -> venderLivro();
                    case 2 -> venderRevista();
                    case 3 -> {
                        System.out.println("Voltando...");
                        mostrarMenuCliente();
                    }
                }
            }
            case 4 -> {
                System.out.println("Voltando...");
                mostrarMenu();
            }
            case 5 -> System.out.println("Saindo...");
        }
    }

    // ============== AREA DO ADMINISTRADOR ====================

    @Override
    public void adicionarLivro() {

        Scanner inputAdicionar = new Scanner(System.in);

        System.out.println("=-=-=-=-=-=-=-= Adicionar livro =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o título do livro: ");
        String tituloLivro = inputAdicionar.nextLine();

        System.out.println("Digite o gênero do livro: ");
        String generoLivro = inputAdicionar.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autorLivro = inputAdicionar.nextLine();

        System.out.println("Digite o ano de publicação do livro: ");
        int anoPublicacaoLivro = inputAdicionar.nextInt();

        System.out.println("Digite a editora do livro: ");
        String editoraLivro = inputAdicionar.nextLine();

        System.out.println("Adicionando livro...");

        Livro livro = new Livro(tituloLivro, generoLivro, autorLivro, anoPublicacaoLivro, editoraLivro);

    }

    @Override
    public void excluirLivro() {

    }

    @Override
    public void adicionarRevista() {

    }

    @Override
    public void excluirRevista() {

    }

    @Override
    public void adicionarCliente() {

    }

    @Override
    public void excluirCliente() {

    }

    // =================== AREA DO CLIENTE ===========================

    @Override
    public void comprarLivro() {
        System.out.println("<----------- Catálogo de livros ----------->");
        // service - listar dos os livros
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Comprar livro =-=-=-=-=-=-=-=-=");
        System.out.println("Digite o nome do livro: ");
        Scanner inputComprar = new Scanner(System.in);
        String nomeLivro = inputComprar.nextLine();

        System.out.println("Livro comprado!");

    }

    @Override
    public void venderLivro() {

    }

    @Override
    public void favoritarLivro() {

    }

    @Override
    public void comprarRevista() {
        System.out.println("<----------- Catálogo de revistas ----------->");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Comprar revista =-=-=-=-=-=-=-=-=");
        System.out.println("Digite o nome da revista: ");
        Scanner inputComprar = new Scanner(System.in);
        String nomeRevista = inputComprar.nextLine();

        System.out.println("Revista comprada!");

    }

    @Override
    public void venderRevista() {

    }

    @Override
    public void favoritarRevista() {

    }
}

package Presentation.Cli;

import Domain.Services.Contracts.IEstoqueService;
import Domain.Services.Contracts.ILivroService;
import Domain.Services.Contracts.IRevistaService;

import Domain.Entities.*;
import Shared.Utils.ConsoleHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class CliFacade {
    private final ILivroService _livroService;
    private final IRevistaService _revistaService;
    private final IEstoqueService _estoqueService;

    public CliFacade(ILivroService livroService, IRevistaService revistaService, IEstoqueService estoqueService) {
        this._livroService = livroService;
        this._revistaService = revistaService;
        this._estoqueService = estoqueService;
    }

    public void mostrarMenu() { // TODO: Implementar menu
        int opcaoMenu;
        do {
            ConsoleHandler.clearConsole();
            this.mostrarCabecalhoInicial();
            Scanner inputMenu = new Scanner(System.in);
            System.out.print(">>> ");

            opcaoMenu = inputMenu.nextInt();

            switch (opcaoMenu) {
                case 1 -> {
                    mostrarMenuAdmin();
                    break;
                }
                case 2 -> {
                    mostrarMenuCliente();
                    break;
                }
                case 3 -> {
                    System.out.println("Saindo...");
                    break;
                }
                default -> System.out.println("Opcão inválida!");
            }
        } while (opcaoMenu != 3);
    }

    private void mostrarCabecalhoInicial() { // TODO: Implementar cabeçalho inicial
        this.mostrarTitulo();
        System.out.println("=-=-=-=-=-=-=-= Menu de opções =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - administrador");
        System.out.println("[2] - cliente");
        System.out.println("[3] - sair");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    private void mostrarTitulo() { // TODO: Implementar titulo
        System.out.println();
        System.out.println("\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEE\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFB\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEE\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B \uD83C\uDDF8\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF4\u200B\u200B\u200B\u200B\u200B \uD83C\uDDE8\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF9\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B");
        System.out.println();
        System.out.println("Ⓢⓔⓙⓐ ⓑⓔⓜ ⓥⓘⓝⓓⓞ");
        System.out.println();
    }

    // ============== AREA DO ADMINISTRADOR ====================

    private void mostrarMenuAdmin() { // TODO: Implementar menu do administrador
        ConsoleHandler.clearConsole();
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Menu do administrador =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - adicionar");
        System.out.println("[2] - excluir");
        System.out.println("[3] - cliente");
        System.out.println("[4] - voltar");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Scanner inputAdmin = new Scanner(System.in);
        System.out.print(">>> ");
        int opcaoAdmin = inputAdmin.nextInt();

        switch (opcaoAdmin) {
            case 1 -> { // Adicionar
                System.out.println("======================================");
                System.out.println("Deseja ADICIONAR um livro ou uma revista?");
                System.out.println("[1] - livro");
                System.out.println("[2] - revista");
                System.out.println("[3] - voltar");

                Scanner inputExcluir = new Scanner(System.in);
                System.out.print(">>> ");
                int opcaoExcluir = inputExcluir.nextInt();

                switch (opcaoExcluir) {
                    case 1 -> adicionarLivro();
                    case 2 -> adicionarRevista();
                    case 3 -> {
                        System.out.println("Voltando...");
                        mostrarMenuAdmin();
                    }
                }
            }
            case 2 -> { // Excluir
                System.out.println("======================================");
                System.out.println("Deseja EXCLUIR um livro ou uma revista?");
                System.out.println("[1] - livro");
                System.out.println("[2] - revista");
                System.out.println("[3] - voltar");

                Scanner inputAdicionar = new Scanner(System.in);
                System.out.print(">>> ");
                int opcaoAdicionar = inputAdicionar.nextInt();

                switch (opcaoAdicionar) {
                    case 1 -> excluirLivro();
                    case 2 -> excluirRevista();
                    case 3 -> {
                        System.out.println("Voltando...");
                        mostrarMenuAdmin();
                    }
                }
            }
            case 3 -> { // Cliente
                System.out.println("======================================");
                System.out.println("Deseja EXCLUIR ou ADICIONAR um cliente?");
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
            }
        }
    }

    // ============== AREA DO ADMINISTRADOR - SERVICE ====================

    private void adicionarLivro() { // TODO: Adicionar livro no estoque
        Scanner inputAdicionarLivro = new Scanner(System.in);

        System.out.println("=-=-=-=-=-=-=-= Adicionar livro =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o título do livro: ");
        String tituloLivro = inputAdicionarLivro.nextLine();

        System.out.println("Digite o gênero do livro: ");
        String generoLivro = inputAdicionarLivro.nextLine();

        System.out.println("Digite o autor do livro: ");
        String autorLivro = inputAdicionarLivro.nextLine();

        System.out.println("Digite o ano de publicação do livro: ");
        int anoPublicacaoLivro = inputAdicionarLivro.nextInt();

        System.out.println("Digite a editora do livro: ");
        String editoraLivro = inputAdicionarLivro.nextLine();

        Livro livro = new Livro(tituloLivro, generoLivro, autorLivro, anoPublicacaoLivro, editoraLivro);

        System.out.println("=====================================");

        this._livroService.criar(livro);

        System.out.println("Quantidade de livros no estoque:");
        int quantidadeLivro = inputAdicionarLivro.nextInt();

        System.out.println("Preço do livro:");
        double precoLivro = inputAdicionarLivro.nextDouble();

        ArrayList<ItemEstoque> itemsEstoque = new ArrayList<>();
        ItemEstoque itemEstoque = new ItemEstoque(livro, quantidadeLivro, precoLivro);
        itemsEstoque.add(itemEstoque);
        this._estoqueService.salvar(itemsEstoque);

        System.out.println("O Livro foi Adicionado com sucesso!");
    }

    private void excluirLivro() { // TODO: Excluir livro no estoque
        Scanner inputExcluirLivro = new Scanner(System.in);

        System.out.println("<----------- Catálogo de livros ----------->");
        var livrosAtuais = this._livroService.buscar();
        for (Livro livro:livrosAtuais) {
            System.out.println(livro.toString());
        }

        System.out.println("=-=-=-=-=-=-=-= Excluir livro =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome do livro: ");
        String nomeLivro = inputExcluirLivro.nextLine();

        System.out.println("Digite o ID do livro: ");
        String idLivro = inputExcluirLivro.nextLine();

        this._livroService.deletar(idLivro);

        System.out.println("<------------ Catálogo de livros Atualizadas ----------->");
        var livrosAtualizados = this._livroService.buscar();
        for (Livro livro:livrosAtualizados) {
            System.out.println(livro.toString());
        }

        System.out.println("Excluindo livro...");

    }

    private void adicionarRevista() { // TODO: Adicionar revista no estoque
        Scanner inputAdicionarRevista = new Scanner(System.in);

        System.out.println("=-=-=-=-=-=-=-= Adicionar revista =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o título da revista: ");
        String tituloRevista = inputAdicionarRevista.nextLine();

        System.out.println("Digite o gênero da revista: ");
        String generoRevista = inputAdicionarRevista.nextLine();

        System.out.println("Digite o autor da revista: ");
        String autorRevista = inputAdicionarRevista.nextLine();

        System.out.println("Digite o ano de publicação da revista: ");
        int anoPublicacaoRevista = inputAdicionarRevista.nextInt();

        System.out.println("Digite a editora da revista: ");
        String editoraRevista = inputAdicionarRevista.nextLine();

        System.out.println("Adicionando revista...");

        Revista revista = new Revista(tituloRevista, generoRevista, autorRevista, anoPublicacaoRevista, editoraRevista);

        System.out.println("=====================================");

        this._revistaService.criar(revista);

        System.out.println("Quantidade de revistas no estoque:");
        int quantidadeRevista = inputAdicionarRevista.nextInt();

        System.out.println("Preço da revista:");
        double precoRevista = inputAdicionarRevista.nextDouble();

        ArrayList<ItemEstoque> itemsEstoque = new ArrayList<>();
        ItemEstoque itemEstoque = new ItemEstoque(revista, quantidadeRevista, precoRevista);
        itemsEstoque.add(itemEstoque);
        this._estoqueService.salvar(itemsEstoque);

        System.out.println("A Revista foi Adicionada com sucesso!");
    }

    private void excluirRevista() { // TODO: Excluir revista no estoque
        Scanner inputExcluirRevista = new Scanner(System.in);

        System.out.println("<----------- Catálogo de revistas ----------->");
        var revistasAtuais = this._revistaService.buscar();
        for (Revista revista:revistasAtuais) {
            System.out.println(revista.toString());
        }

        System.out.println("=-=-=-=-=-=-=-= Excluir revista =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome da revista: ");
        String nomeRevista = inputExcluirRevista.nextLine();

        System.out.println("Digite o ID da revista: ");
        String idRevista = inputExcluirRevista.nextLine();

        this._revistaService.deletar(idRevista);

        System.out.println("<------------ Catálogo de revistas Atualizadas ----------->");
        var revistasAtualizadas = this._revistaService.buscar();
        for (Revista revista:revistasAtualizadas) {
            System.out.println(revista.toString());
        }
    }

    private void adicionarCliente() { // TODO: Adicionar cliente
        Scanner inputAdicionarCliente = new Scanner(System.in);

        System.out.println("=-=-=-=-=-=-=-= Adicionar cliente =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = inputAdicionarCliente.nextLine();

        System.out.println("Digite o email do cliente: ");
        String emailCliente = inputAdicionarCliente.nextLine();

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Endereço do cliente =-=-=-=-=-=-=-");
        System.out.println("Digite a rua: ");
        String ruaCliente = inputAdicionarCliente.nextLine();

        System.out.println("Digite a cidade: ");
        String cidadeCliente = inputAdicionarCliente.nextLine();

        System.out.println("Digite o estado: ");
        String estadoCliente = inputAdicionarCliente.nextLine();

        System.out.println("Digite o CEP: ");
        String cepCliente = inputAdicionarCliente.nextLine();

        System.out.println("Digite o país: ");
        String paisCliente = inputAdicionarCliente.nextLine();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("Adicionando cliente...");

        Endereco enderecoCliente = new Endereco(ruaCliente, cidadeCliente, estadoCliente, cepCliente, paisCliente);
        Cliente cliente = new Cliente(nomeCliente, emailCliente, enderecoCliente, null, null);

        // Service de Cliente - criar cliente
    }

    private void excluirCliente() { // TODO: Excluir cliente
        Scanner inputExcluirCliente = new Scanner(System.in);

        System.out.println("<----------- Catálogo de clientes ----------->");

        // Service de Cliente - listar todos os clientes

        System.out.println("=-=-=-=-=-=-=-= Excluir cliente =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = inputExcluirCliente.nextLine();

        System.out.println("Digite o ID do cliente: ");
        String idCliente = inputExcluirCliente.nextLine();

        System.out.println("<------------ Catálogo de clientes Atualizadas ----------->");
        // Service de Cliente - listar todos os clientes

        System.out.println("Excluindo cliente...");

        // Service de Cliente - criar cliente

    }

    // ============== AREA DO CLIENTE ====================

    private void mostrarMenuCliente() { // TODO: Implementar menu do cliente
        ConsoleHandler.clearConsole();
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Menu do cliente =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - comprar");
        System.out.println("[2] - favoritar");
        System.out.println("[3] - vender");
        System.out.println("[4] - voltar");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Scanner inputCliente = new Scanner(System.in);
        System.out.print(">>> ");
        int opcaoCliente = inputCliente.nextInt();

        switch (opcaoCliente) {
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
            }
        }
    }

    // ============== AREA DO CLIENTE - SERVICE ====================

    private void comprarLivro() { // TODO: Comprar livro
        Scanner inputComprar = new Scanner(System.in);

        System.out.println("<----------- Catálogo de livros ----------->");
        var livrosAtuais = this._livroService.buscar();
        for (Livro livro:livrosAtuais) {
            System.out.println(livro.toString());
        }

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Comprar livro =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome do livro: ");
        String nomeLivro = inputComprar.nextLine();

        System.out.println("Digite o ID do livro: ");
        String idLivro = inputComprar.nextLine();

        // service - comprar livro

        System.out.println("Livro comprado!");

    }

    private void venderLivro() { // TODO: Vender livro
        System.out.println("<----------- Seus catálogos de livros ----------->");
        // service - listar livros comprados por voce

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Vender livro =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome do livro: ");
        Scanner inputVender = new Scanner(System.in);
        String nomeLivro = inputVender.nextLine();

        System.out.println("Livro vendido!");
    }

    private void favoritarLivro() { // TODO: Favoritar livro
        System.out.println("<----------- Seus catálogos de livros ----------->");
        // service - listar livros favoritos

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Favoritar livro =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome do livro: ");
        Scanner inputFavoritar = new Scanner(System.in);
        String nomeLivro = inputFavoritar.nextLine();

        System.out.println("Livro favoritado!");

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Livros favoritados =-=-=-=-=-=-=-=-");
        // service - listar livros favoritados

    }

    private void comprarRevista() { // TODO: Comprar revista
        System.out.println("<----------- Catálogo de revistas ----------->");
        var revistasAtuais = this._revistaService.buscar();
        for (Revista revista:revistasAtuais) {
            System.out.println(revista.toString());
        }

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Comprar revista =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome da revista: ");
        Scanner inputComprar = new Scanner(System.in);
        String nomeRevista = inputComprar.nextLine();

        System.out.println("Revista comprada!");

    }

    private void venderRevista() { // TODO: Vender revista
        System.out.println("<----------- Seus catálogos de revistas ----------->");
        var revistasAtuais = this._revistaService.buscar();
        for (Revista revista:revistasAtuais) {
            System.out.println(revista.toString());
        }

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Vender revista =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome da revista: ");
        Scanner inputVender = new Scanner(System.in);
        String nomeRevista = inputVender.nextLine();

        System.out.println("Revista vendida!");

    }

    private void favoritarRevista() { // TODO: Favoritar revista
        System.out.println("<----------- Seus catálogos de revistas ----------->");
        // service - listar revistas favoritas

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Favoritar revista =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome da revista: ");
        Scanner inputFavoritar = new Scanner(System.in);
        String nomeRevista = inputFavoritar.nextLine();

        System.out.println("Revista favoritada!");

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Revista favoritadas =-=-=-=-=-=-=-=-");
        // service - listar revistas favoritadas
    }
}

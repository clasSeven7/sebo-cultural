package Presentation.Cli;

import Domain.Entities.*;
import Domain.Services.Contracts.IEstoqueService;
import Domain.Services.Contracts.ILivroService;
import Domain.Services.Contracts.IRevistaService;
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

    public void mostrarMenu() {
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
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcaoMenu != 3);
    }

    private void mostrarCabecalhoInicial() {
        this.mostrarTitulo();
        System.out.println("=-=-=-=-=-=-=-= Menu de opções =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - administrador");
        System.out.println("[2] - cliente");
        System.out.println("[3] - sair");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    private void mostrarTitulo() {
        System.out.println();
        System.out.println("\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEE\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFB\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEE\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B \uD83C\uDDF8\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF4\u200B\u200B\u200B\u200B\u200B \uD83C\uDDE8\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF9\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B");
        System.out.println();
        System.out.println("Ⓢⓔⓙⓐ ⓑⓔⓜ ⓥⓘⓝⓓⓞ");
        System.out.println();
    }

    private void mostrarMenuAdmin() {
        ConsoleHandler.clearConsole();
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Menu do administrador =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - excluir");
        System.out.println("[2] - adicionar");
        System.out.println("[3] - cliente");
        System.out.println("[4] - voltar");
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
            }
        }
    }

    private void excluirLivro() {

    }

    private void excluirRevista() {

    }

    // ============== AREA DO ADMINISTRADOR ====================

    private void adicionarLivro() {
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

    private void adicionarRevista() {
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

    private void mostrarMenuCliente() {
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

    private void adicionarCliente() {
        Scanner inputAdicionarCliente = new Scanner(System.in);

        System.out.println("=-=-=-=-=-=-=-= Adicionar cliente =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = inputAdicionarCliente.nextLine();

        System.out.println("Digite o email do cliente: ");
        String emailCliente = inputAdicionarCliente.nextLine();

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

    }

    private void excluirCliente() {

    }

    // =================== AREA DO CLIENTE ===========================

    private void comprarLivro() {
        Scanner inputComprar = new Scanner(System.in);

        System.out.println("<----------- Catálogo de livros ----------->");
        // Service - listar todos os livros adicionados pelo ADM
        System.out.println();

        System.out.println("=-=-=-=-=-=-=-= Comprar livro =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o nome do livro: ");
        String nomeLivro = inputComprar.nextLine();

        System.out.println("Digite o ID do livro: ");
        String idLivro = inputComprar.nextLine();

        System.out.println("Livro comprado!");

    }

    private void venderLivro() {
        System.out.println("<----------- Seus catálogos de livros ----------->");
        // service - listar dos os livros
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Vender livro =-=-=-=-=-=-=-=-=");
        System.out.println("Digite o nome do livro: ");
        Scanner inputVender = new Scanner(System.in);
        String nomeLivro = inputVender.nextLine();

        System.out.println("Livro vendido!");
    }

    private void favoritarLivro() {
        System.out.println("<----------- Seus catálogos de livros ----------->");
        // Service - listar todos os livros adiconados pelo ADM
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Favoritar livro =-=-=-=-=-=-=-=-=");
        System.out.println("Digite o nome do livro: ");
        Scanner inputFavoritar = new Scanner(System.in);
        String nomeLivro = inputFavoritar.nextLine();

        System.out.println("Livro favoritado!");

        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Livros favoritados =-=-=-=-=-=-=-=-");
        // Service - listar dos os livros favoritados pelo cliente

    }

    private void comprarRevista() {
        System.out.println("<----------- Catálogo de revistas ----------->");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Comprar revista =-=-=-=-=-=-=-=-=");
        System.out.println("Digite o nome da revista: ");
        Scanner inputComprar = new Scanner(System.in);
        String nomeRevista = inputComprar.nextLine();

        System.out.println("Revista comprada!");

    }

    private void venderRevista() {
        System.out.println("<----------- Seus catálogos de revistas ----------->");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Vender revista =-=-=-=-=-=-=-=-=");
        System.out.println("Digite o nome da revista: ");
        Scanner inputVender = new Scanner(System.in);
        String nomeRevista = inputVender.nextLine();

        System.out.println("Revista vendida!");

    }

    private void favoritarRevista() {
        System.out.println("<----------- Seus catálogos de revistas ----------->");
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

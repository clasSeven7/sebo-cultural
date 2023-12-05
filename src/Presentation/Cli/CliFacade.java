package Presentation.Cli;

import Domain.Services.Contracts.IClienteService;
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
    private final IClienteService _clienteService;

    public CliFacade(ILivroService livroService, IRevistaService revistaService,
                     IEstoqueService estoqueService,
                     IClienteService clienteService) {
        this._livroService = livroService;
        this._revistaService = revistaService;
        this._estoqueService = estoqueService;
        this._clienteService = clienteService;
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
                }
                case 2 -> {
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opcão inválida!");
            }
        } while (opcaoMenu != 2);
    }

    private void mostrarCabecalhoInicial() { // TODO: Implementar cabeçalho inicial
        this.mostrarTitulo();
        System.out.println("=-=-=-=-=-=-=-= Menu de opções =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - administrador");
        System.out.println("[2] - sair");
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
        System.out.println("[5] - Mostrar todos os dados");
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
            case 5 -> {
                this.mostrarTodosOsDados();
            }
            default -> System.out.println("Opcao Invalida!");
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

        System.out.println("Quantidade de livros no estoque:");
        int quantidadeLivro = inputAdicionarLivro.nextInt();

        System.out.println("Preço do livro:");
        double precoLivro = inputAdicionarLivro.nextDouble();

        ArrayList<ItemEstoque> itemsEstoque = new ArrayList<>();
        Livro livro = new Livro(tituloLivro, generoLivro, autorLivro, anoPublicacaoLivro, editoraLivro);
        ItemEstoque itemEstoque = new ItemEstoque(livro, quantidadeLivro, precoLivro);
        itemsEstoque.add(itemEstoque);
        this._livroService.criar(livro);
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

        System.out.println("Digite o ID do livro: ");
        String idLivro = inputExcluirLivro.nextLine();
        this._livroService.deletar(idLivro);
        System.out.println("Livro excluido...");

        System.out.println("<------------ Catálogo de livros Atualizadas ----------->");
        var livrosAtualizados = this._livroService.buscar();
        for (Livro livro:livrosAtualizados) {
            System.out.println(livro.toString());
        }
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

        System.out.println("Quantidade de revistas no estoque:");
        int quantidadeRevista = inputAdicionarRevista.nextInt();

        System.out.println("Preço da revista:");
        double precoRevista = inputAdicionarRevista.nextDouble();

        ArrayList<ItemEstoque> itemsEstoque = new ArrayList<>();
        Revista revista = new Revista(tituloRevista, generoRevista, autorRevista, anoPublicacaoRevista, editoraRevista);
        ItemEstoque itemEstoque = new ItemEstoque(revista, quantidadeRevista, precoRevista);
        itemsEstoque.add(itemEstoque);

        this._revistaService.criar(revista);
        this._estoqueService.salvar(itemsEstoque);

        System.out.println("A Revista foi Adicionada com sucesso!");
    }

    private void excluirRevista() {
        Scanner inputExcluirRevista = new Scanner(System.in);

        System.out.println("<----------- Catálogo de revistas ----------->");
        var revistasAtuais = this._revistaService.buscar();
        for (Revista revista:revistasAtuais) {
            System.out.println(revista.toString());
        }

        System.out.println("=-=-=-=-=-=-=-= Excluir revista =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o ID da revista: ");
        String idRevista = inputExcluirRevista.nextLine();

        this._revistaService.deletar(idRevista);
        System.out.println("A Revista foi excluida com sucesso!");

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

        Endereco enderecoCliente = new Endereco(ruaCliente, cidadeCliente, estadoCliente, cepCliente, paisCliente);
        Cliente cliente = new Cliente(nomeCliente, emailCliente, enderecoCliente);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("Cliente adicionado!..");

        this._clienteService.criar(cliente);
        System.out.println("O Cliente foi adicionado com sucesso!");
    }

    private void excluirCliente() { // TODO: Excluir cliente
        Scanner inputExcluirCliente = new Scanner(System.in);

        System.out.println("<----------- Catálogo de clientes ----------->");

        var clientes = this._clienteService.buscar();
        for (Cliente cliente:clientes) {
            System.out.println(cliente.toString());
        }

        System.out.println("=-=-=-=-=-=-=-= Excluir cliente =-=-=-=-=-=-=-=-=");

        System.out.println("Digite o ID do cliente: ");
        String idCliente = inputExcluirCliente.nextLine();

        this._clienteService.deletar(idCliente);
        System.out.println("Cliente excluido com sucesso!...");


        System.out.println("<------------ Catálogo de clientes Atualizadas ----------->");
        clientes = this._clienteService.buscar();
        for (Cliente cliente:clientes) {
            System.out.println(cliente.toString());
        }

    }

    private void mostrarTodosOsDados() {
        System.out.println("<------------ Catálogo de livros Atualizados ----------->");
        var livros = this._livroService.buscar();
        for (Livro livro:livros) {
            System.out.println(livro.toString());
        }

        System.out.println("\n");

        System.out.println("<------------ Catálogo de revistas Atualizadas ----------->");
        var revistas = this._revistaService.buscar();
        for (Revista revista:revistas) {
            System.out.println(revista.toString());
        }

        System.out.println("\n");

        System.out.println("<------------ Clientes Atualizados ----------->");
        var clientes = this._clienteService.buscar();

        for (Cliente cliente:clientes) {
            System.out.println(cliente.toString());
        }
    }
}

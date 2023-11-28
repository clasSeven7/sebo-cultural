package Presentation.Cli;

import Domain.Entities.Cliente;
import Domain.Entities.Endereco;
import Domain.Entities.Livro;
import Domain.Services.Contracts.IEstoqueService;
import Domain.Services.Contracts.ILivroService;
import Domain.Services.Contracts.IRevistaService;

import java.util.Scanner;

public class CliFacade implements OpcaoAdmin, OpcaoCliente {

    private final ILivroService _livroService;
<<<<<<< Updated upstream
<<<<<<< HEAD
    private final IRevistaService _revistaService;
    private final ILivroService _itemEstoqueService;

    public CliFacade(ILivroService livroService, IRevistaService revistaService, ILivroService itemEstoqueService, IEstoqueService estoqueService) {
        _livroService = livroService;
        _revistaService = revistaService;
        _itemEstoqueService = itemEstoqueService;
=======

    public CliFacade(ILivroService livroService) {
        _livroService = livroService;
=======
    private final ILivroService _itemEstoqueService;
    private final IEstoqueService _estoqueService;
    private final IRevistaService _revistaService;

    public CliFacade(ILivroService livroService, IRevistaService revistaService, IEstoqueService estoqueService, ILivroService itemEstoqueService) {
        _livroService = livroService;
        _revistaService = revistaService;
        _estoqueService = estoqueService;
        _itemEstoqueService = itemEstoqueService;

>>>>>>> Stashed changes
    }

    private void mostrarTitulo() {
        System.out.println();
        System.out.println("\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEE\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFB\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEE\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B \uD83C\uDDF8\u200B\u200B\u200B\u200B\u200B\uD83C\uDDEA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF4\u200B\u200B\u200B\u200B\u200B \uD83C\uDDE8\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF9\u200B\u200B\u200B\u200B\u200B\uD83C\uDDFA\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF7\u200B\u200B\u200B\u200B\u200B\uD83C\uDDE6\u200B\u200B\u200B\u200B\u200B\uD83C\uDDF1\u200B\u200B\u200B\u200B\u200B");
        System.out.println();
        System.out.println("Ⓢⓔⓙⓐ ⓑⓔⓜ ⓥⓘⓝⓓⓞ");
        System.out.println();
>>>>>>> 8c3162a15a868adce0b632afcaaa20164a02b4fa
    }

    public void mostrarMenu() {
        this.mostrarTitulo();
        System.out.println("=-=-=-=-=-=-=-= Menu de opções =-=-=-=-=-=-=-=-=");
        System.out.println("[1] - administrador");
        System.out.println("[2] - cliente");
        System.out.println("[3] - sair");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        Scanner inputMenu = new Scanner(System.in);
        System.out.print(">>> ");
        int opcaoMenu = inputMenu.nextInt();

        switch (opcaoMenu) {
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
                mostrarMenu();
            }
            case 5 -> System.out.println("Saindo...");
        }
    }

    // ============== AREA DO ADMINISTRADOR ====================

    @Override
    public void adicionarLivro() {
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

        Livro itemEstoque = new Livro(livro, quantidadeLivro, precoLivro);

<<<<<<< HEAD
        this._itemEstoqueService.criar(itemEstoque);
<<<<<<< Updated upstream
=======
        // this._itemEstoqueService.criar(itemEstoque);

>>>>>>> 8c3162a15a868adce0b632afcaaa20164a02b4fa
=======
>>>>>>> Stashed changes
    }

    @Override
    public void excluirLivro() {

    }

    @Override
    public void adicionarRevista() {
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

        Livro revista = new Livro(tituloRevista, generoRevista, autorRevista, anoPublicacaoRevista, editoraRevista);

        System.out.println("=====================================");

        this._revistaService.criar(revista);

        System.out.println("Quantidade de revistas no estoque:");
        int quantidadeRevista = inputAdicionarRevista.nextInt();

        System.out.println("Preço da revista:");
        double precoRevista = inputAdicionarRevista.nextDouble();

        Livro itemEstoque = new Livro(revista, quantidadeRevista, precoRevista);

        this._itemEstoqueService.criar(itemEstoque);

    }

    @Override
    public void excluirRevista() {

    }

    @Override
    public void adicionarCliente() {
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

    @Override
    public void excluirCliente() {

    }

    // =================== AREA DO CLIENTE ===========================

    @Override
    public void comprarLivro() {
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

    @Override
    public void venderLivro() {
        System.out.println("<----------- Seus catálogos de livros ----------->");
        // service - listar dos os livros
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Vender livro =-=-=-=-=-=-=-=-=");
        System.out.println("Digite o nome do livro: ");
        Scanner inputVender = new Scanner(System.in);
        String nomeLivro = inputVender.nextLine();

        System.out.println("Livro vendido!");
    }

    @Override
    public void favoritarLivro() {
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
        System.out.println("<----------- Seus catálogos de revistas ----------->");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-= Vender revista =-=-=-=-=-=-=-=-=");
        System.out.println("Digite o nome da revista: ");
        Scanner inputVender = new Scanner(System.in);
        String nomeRevista = inputVender.nextLine();

        System.out.println("Revista vendida!");

    }

    @Override
    public void favoritarRevista() {
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

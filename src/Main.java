import Domain.Repositories.IClienteRepository;
import Domain.Repositories.IEstoqueRepository;
import Domain.Repositories.ILivroRepository;
import Domain.Repositories.IRevistaRepository;

import Domain.Services.ClienteService;
import Domain.Services.Contracts.IClienteService;
import Domain.Services.Contracts.IEstoqueService;
import Domain.Services.Contracts.ILivroService;
import Domain.Services.Contracts.IRevistaService;

import Domain.Services.EstoqueService;
import Domain.Services.LivroService;
import Domain.Services.RevistaService;

import Infrastructure.ClienteRepository;
import Infrastructure.EstoqueRepository;
import Infrastructure.LivroRepository;
import Infrastructure.RevistaRepository;

import Presentation.Cli.CliFacade;

public class Main {
    public static void main(String[] args) {
        ILivroRepository livroRepository = new LivroRepository();
        ILivroService livroService = new LivroService(livroRepository);

        IRevistaRepository revistaRepository = new RevistaRepository();
        IRevistaService revistaService = new RevistaService(revistaRepository);

        IEstoqueRepository estoqueRepository = new EstoqueRepository();
        IEstoqueService estoqueService = new EstoqueService(estoqueRepository);

        IClienteRepository clienteRepository = new ClienteRepository();
        IClienteService clienteService = new ClienteService(clienteRepository);

        var cli = new CliFacade(livroService, revistaService, estoqueService, clienteService);
        cli.mostrarMenu();
    }
}
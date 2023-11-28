import Domain.Entities.Livro;
import Domain.Repositories.IEstoqueRepository;
import Domain.Repositories.ILivroRepository;
import Domain.Repositories.IRevistaRepository;
import Domain.Services.Contracts.IEstoqueService;
import Domain.Services.Contracts.ILivroService;
import Domain.Services.Contracts.IRevistaService;
import Domain.Services.EstoqueService;
import Domain.Services.LivroService;
import Domain.Services.RevistaService;

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

        //Testes hard code para entidades
        var l = new Livro(
                "One Piece",
                "Manga / Shonnen",
                "Eiichiro Oda",
                1997,
                "Shueisha - Shonnen Jump"
        );

        livroService.criar(l);
        var cli = new CliFacade(livroService, itemEstoqueService);
        cli.mostrarMenu();
    }
}
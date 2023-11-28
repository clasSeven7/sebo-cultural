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

        var cli = new CliFacade(livroService, revistaService, estoqueService);
        cli.mostrarMenu();

        //Remove esses comentarios para testar a persitencia em json
//        var l1 = new Livro(
//                "One Piece",
//                "Manga / Shonnen",
//                "Eiichiro Oda",
//                1997,
//                "Shueisha - Shonnen Jump"
//        );
//
//        var l2 = new Livro(
//                "Naruto",
//                "Manga / Shonnen",
//                "Masashi Kishimoto",
//                1999,
//                "Shueisha - Shonnen Jump"
//        );
//
//        var l3 = new Livro(
//                "Bleach",
//                "Manga / Shonnen",
//                "Tite Kubo",
//                2000,
//                "Shueisha - Shonnen Jump"
//        );
//
//        var r1 = new Revista(
//                "Forbes",
//                "Economia",
//                "-",
//                2023,
//                "Forbes"
//        );
//
//
//        livroService.criar(l1);
//        livroService.criar(l2);
//        livroService.criar(l3);
//
//        revistaService.criar(r1);
//
//        var livros = livroService.buscar();
//        var revistas = revistaService.buscar();
//
//        for (Livro livro:livros) {
//            System.out.println(livro.toString());
//        }




    }
}
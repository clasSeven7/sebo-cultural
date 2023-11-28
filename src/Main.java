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

public class Main {
    public static void main(String[] args) {
        ILivroRepository livroRepository = new LivroRepository();
        ILivroService livroService = new LivroService(livroRepository);

        IRevistaRepository revistaRepository = new RevistaRepository();
        IRevistaService revistaService = new RevistaService(revistaRepository);

        IEstoqueRepository estoqueRepository = new EstoqueRepository();
        IEstoqueService estoqueService = new EstoqueService(estoqueRepository);


        //cli aqui...
    }
}
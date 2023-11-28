package Domain.Services;

import Domain.Entities.Livro;
import Domain.Repositories.ILivroRepository;
import Domain.Services.Contracts.ILivroService;

import java.util.ArrayList;

public class LivroService implements ILivroService {
    private final ILivroRepository _livroRepository;

    public LivroService(ILivroRepository livroRepository) {
        this._livroRepository = livroRepository;
    }

    public ArrayList<Livro> buscar() {
        try {
            return this._livroRepository.buscar();
        } catch (Exception e) {
            System.out.println("Nao foi possível obter dados de livros...");
            return new ArrayList<>();
        }
    }

    public void criar(Livro livro) {
        try {
            this._livroRepository.criar(livro);
        } catch (Exception e) {
            System.out.println("Nao foi possível criar livro...");
        }
    }

    public void atualizar(String livroId, Livro livro) {
        try {
            this._livroRepository.atualizar(livroId, livro);
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar livro...");
        }
    }

    public void deletar(String livroId) {
        try {
            this._livroRepository.deletar(livroId);
        } catch (Exception e) {
            System.out.println("Não foi possível deletar livro...");
        }
    }
}

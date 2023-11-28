package Domain.Repositories;

import Domain.Entities.Livro;

import java.util.ArrayList;

public interface ILivroRepository {
    ArrayList<Livro> buscar();
    void criar(Livro livro);
    void atualizar(String livroId, Livro livro);
    void deletar(String livroId);
}

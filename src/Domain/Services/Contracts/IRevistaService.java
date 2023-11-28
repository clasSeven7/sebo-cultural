package Domain.Services.Contracts;

import Domain.Entities.Livro;
import Domain.Entities.Revista;

import java.util.ArrayList;

public interface IRevistaService {
    ArrayList<Revista> buscar();
    void criar(Livro revista);
    void atualizar(String revistaId, Revista revista);
    void deletar(String revistaId);
}

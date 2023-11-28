package Domain.Repositories;

import Domain.Entities.Revista;

import java.util.ArrayList;

public interface IRevistaRepository {
    ArrayList<Revista> buscar();
    void criar(Revista revista);
    void atualizar(String revistaId, Revista revista);
    void deletar(String revistaId);
}

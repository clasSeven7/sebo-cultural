package Domain.Services.Contracts;

import Domain.Entities.Revista;

import java.util.ArrayList;


public interface IRevistaService {
    ArrayList<Revista> buscar();
    void criar(Revista revista);
    void atualizar(String revistaId, Revista revista);
    void deletar(String revistaId);
}


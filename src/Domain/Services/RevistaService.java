package Domain.Services;

import Domain.Entities.Revista;
import Domain.Repositories.IRevistaRepository;
import Domain.Services.Contracts.IRevistaService;

import java.util.ArrayList;

public class RevistaService implements IRevistaService {
    private IRevistaRepository _revistaRepository;

    public RevistaService(IRevistaRepository revistaRepository) {
        this._revistaRepository = revistaRepository;
    }

    public ArrayList<Revista> buscar() {
        try {
            return this._revistaRepository.buscar();
        } catch (Exception e) {
            System.out.println("Nao foi possivel obter dados de livros...");
            return new ArrayList<>();
        }
    }

    public void criar(Revista revista) {
        try {
            this._revistaRepository.criar(revista);
        } catch (Exception e) {
            System.out.println("Nao foi possivel criar revista...");
        }
    }


    public void atualizar(String revistaId, Revista revista) {
        try {
            this._revistaRepository.atualizar(revistaId, revista);
        } catch (Exception e) {
            System.out.println("Nao foi possivel atualizar revista...");
        }
    }


    public void deletar(String revistaId) {
        try {
            this._revistaRepository.deletar(revistaId);
        } catch (Exception e) {
            System.out.println("Nao foi possivel deletar revista...");
        }
    }
}

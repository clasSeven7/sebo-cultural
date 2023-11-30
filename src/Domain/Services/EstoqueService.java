package Domain.Services;

import Domain.Entities.Estoque;
import Domain.Entities.ItemEstoque;
import Domain.Repositories.IEstoqueRepository;
import Domain.Services.Contracts.IEstoqueService;

import java.util.ArrayList;

public class EstoqueService implements IEstoqueService {
    private final IEstoqueRepository _estoqueRepository;

    public EstoqueService(IEstoqueRepository estoqueRepository) {
        this._estoqueRepository = estoqueRepository;
    }

    public Estoque buscar() {
        return this._estoqueRepository.buscar();
    }

    public void salvar(ArrayList<ItemEstoque> items) {
        this._estoqueRepository.salvar(items);
    }
}

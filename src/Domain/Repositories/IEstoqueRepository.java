package Domain.Repositories;

import Domain.Entities.Estoque;
import Domain.Entities.ItemEstoque;

import java.util.ArrayList;

public interface IEstoqueRepository {
    Estoque buscar();
    void salvar(ArrayList<ItemEstoque> items);
}

package Domain.Services.Contracts;

import Domain.Entities.Estoque;
import Domain.Entities.ItemEstoque;

import java.util.ArrayList;

public interface IEstoqueService {
    Estoque buscar();
    void salvar(ArrayList<ItemEstoque> items);
}

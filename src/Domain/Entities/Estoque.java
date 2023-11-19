package Domain.Entities;

import java.util.ArrayList;
import java.util.Objects;

public class Estoque {
    private ArrayList<ItemEstoque> items = new ArrayList<ItemEstoque>();

    public Estoque() {}

    public void adicionar(ItemBiblioteca itemBiblioteca, int quantidade, double preco) {
        if (!this.itemJaExiste(itemBiblioteca)) {
            this.items.add(new ItemEstoque(itemBiblioteca, quantidade, preco));
        }
    }

    public void excluir(String itemId) {
        this.items.removeIf(itemEstoque -> Objects.equals(itemEstoque.getItem().getId(), itemId));
    }

    public void atualizar(ItemBiblioteca itemBiblioteca, int quantidade, double preco) {
        this.excluir(itemBiblioteca.getId());
        this.adicionar(itemBiblioteca, quantidade, preco);
    }

    private boolean itemJaExiste(ItemBiblioteca itemBiblioteca) {
        return items.stream()
                .anyMatch(itemEstoque -> Objects.equals(itemEstoque.getItem().getId(), itemBiblioteca.getId()));
    }
}

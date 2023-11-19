package Domain.Entities;

public class ItemEstoque extends Entidade {
    private ItemBiblioteca item;
    private int quantidade;
    private double preco;

    public ItemEstoque(ItemBiblioteca item, int quantidade, double preco) {
        super();
        this.setItem(item);
        this.setQuantidade(quantidade);
        this.setPreco(preco);
    }

    public ItemBiblioteca getItem() {
        return this.item;
    }

    public void setItem(ItemBiblioteca item) {
        this.item = item;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ItemEstoque{" +
                "item=" + this.getItem().toString() +
                ", quantidade=" + this.getQuantidade() +
                ", preco=" + this.getPreco() +
                '}';
    }
}

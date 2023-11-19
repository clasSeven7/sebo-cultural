package Domain.Entities;

public class ItemEstoque {
    private ItemBiblioteca item;
    private int quantidade;

    public ItemEstoque(ItemBiblioteca item, int quantidade) {
        this.setItem(item);
        this.setQuantidade(quantidade);
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

    @Override
    public String toString() {
        return "ItemEstoque{" +
                "item=" + this.getItem() +
                ", quantidade=" + this.getQuantidade() +
                '}';
    }
}

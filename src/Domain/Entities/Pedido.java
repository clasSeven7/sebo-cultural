package Domain.Entities;

import java.util.Date;

public class Pedido extends Entidade {
    private ItemEstoque itemEstoque;
    private Date data;
    private String clienteId;

    public Pedido() {}

    public ItemEstoque getItemEstoque() {
        return this.itemEstoque;
    }

    public void setItemEstoque(ItemEstoque itemEstoque) {
        this.itemEstoque = itemEstoque;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "itemEstoque=" + this.itemEstoque.toString() +
                ", data=" + this.data.toString() +
                ", clienteId=" + this.clienteId +
                '}';
    }
}

package Domain.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * A classe `Cliente` representa um usuário cliente no sistema,
 * estendendo a classe base `Usuario`.
 *
 * Esta classe inclui atributos específicos para clientes, como gêneros favoritos
 * e histórico de pedidos.
 */

public class Cliente extends Usuario {

    // Lista de gêneros favoritos do cliente.
    private ArrayList<String> generosFavoritos = new ArrayList<String>();

    // Lista de pedidos feitos pelo cliente.
    private ArrayList<Pedido> historicoPedidos = new ArrayList<Pedido>();

    /**
     * Construtor para criar uma instância da classe `Cliente`.
     *
     * @param nome             O nome do cliente.
     * @param email            O endereço de e-mail do cliente.
     * @param endereco         O endereço do cliente.
     * @param generosFavoritos Lista de gêneros favoritos do cliente.
     * @param historicoPedidos Lista de pedidos feitos pelo cliente.
     */

    public Cliente(
            String nome,
            String email,
            Endereco endereco,
            ArrayList<String> generosFavoritos,
            ArrayList<Pedido> historicoPedidos
    ) {
        super(); // Chama o construtor da classe base (Usuario).
        this.setNome(nome);
        this.setEmail(email);
        this.setPermissao(PermissaoUsuario.CLIENTE);
        this.setEndereco(endereco);
        this.setGenerosFavoritos(generosFavoritos);
        this.setHistoricoPedidos(historicoPedidos);
    }

    /**
     * Obtém o histórico de pedidos do cliente, ordenado por data de forma decrescente.
     *
     * @return Uma lista de pedidos ordenada por data decrescente.
     */

    public ArrayList<Pedido> getHistoricoPedidos() {
        return this.historicoPedidos
                .stream()
                .filter(pedido -> pedido instanceof Pedido)
                .map(pedido -> (Pedido) pedido)
                .sorted(Comparator.comparing(pedido -> {
                    LocalDate dataPedido = ((Pedido) pedido).getData() != null ? LocalDate.parse(((Pedido) pedido).getData().toString()) : null;
                    return dataPedido != null ? dataPedido : LocalDate.MIN;
                }).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Obtém a lista de gêneros favoritos do cliente.
     *
     * @return Lista de gêneros favoritos.
     */

    public ArrayList<String> getGenerosFavoritos() {
        return this.generosFavoritos;
    }

    /**
     * Define a lista de gêneros favoritos do cliente.
     *
     * @param generosFavoritos Lista de gêneros favoritos.
     */

    public void setGenerosFavoritos(ArrayList<String> generosFavoritos) {
        this.generosFavoritos = generosFavoritos;
    }

    /**
     * Define o histórico de pedidos do cliente.
     *
     * @param historicoPedidos Lista de pedidos feitos pelo cliente.
     */

    public void setHistoricoPedidos(ArrayList<Pedido> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }

    /**
     * Retorna uma representação em string do objeto `Cliente`.
     *
     * @return Uma string contendo informações sobre o cliente.
     */

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + this.getId() + '\'' +
                ", nome=" + this.getNome() +
                ", email='" + this.getEmail() + '\'' +
                ", permissao='" + this.getPermissao() + '\'' +
                ", endereco='" + this.getEndereco().toString() + '\'' +
                '}';
    }
}

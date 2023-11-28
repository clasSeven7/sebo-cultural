package Tests;

import Domain.Entities.Cliente;
import Domain.Entities.Endereco;
import Domain.Entities.Pedido;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    public void testGetHistoricoPedidosSortedByDate() {
        Endereco endereco = new Endereco("rua dos bobos", "bossa", "Nova", "12345", "Brasil");
        ArrayList<String> generosFavoritos = new ArrayList<>(Arrays.asList("Genre1", "Genre2"));
        ArrayList<Pedido> historicoPedidos = new ArrayList<>();
        Pedido pedido1 = new Pedido("1", "2023-01-01");
        Pedido pedido2 = new Pedido("1", "2023-01-01");
        historicoPedidos.add(pedido1);
        historicoPedidos.add(pedido2);

        Cliente cliente = new Cliente("John Doe", "john@example.com", endereco, generosFavoritos, historicoPedidos);

        ArrayList<Pedido> sortedPedidos = cliente.getHistoricoPedidos();

    }

    @Test
    public void testGetGenerosFavoritos() {

        Endereco endereco = new Endereco("rua dos bobos", "bossa", "Nova", "12345", "Brasil");
        ArrayList<String> generosFavoritos = new ArrayList<>(Arrays.asList("Genre1", "Genre2"));
        ArrayList<Pedido> historicoPedidos = new ArrayList<>();

        Cliente cliente = new Cliente("John Doe", "john@example.com", endereco, generosFavoritos, historicoPedidos);

        ArrayList<String> result = cliente.getGenerosFavoritos();

        assertEquals(generosFavoritos, result);
    }
}

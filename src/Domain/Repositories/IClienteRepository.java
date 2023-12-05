package Domain.Repositories;

import Domain.Entities.Cliente;

import java.util.ArrayList;

public interface IClienteRepository {
    ArrayList<Cliente> buscar();
    void criar(Cliente cliente);
    void atualizar(String clienteId, Cliente cliente);
    void deletar(String clienteId);
}

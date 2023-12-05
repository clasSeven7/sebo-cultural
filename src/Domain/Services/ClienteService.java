package Domain.Services;

import Domain.Entities.Cliente;
import Domain.Repositories.IClienteRepository;
import Domain.Services.Contracts.IClienteService;

import java.util.ArrayList;

public class ClienteService implements IClienteService {
    private final IClienteRepository _clienteRepository;

    public ClienteService(IClienteRepository clienteRepository) {
        this._clienteRepository = clienteRepository;
    }

    public ArrayList<Cliente> buscar() {
        try {
            return this._clienteRepository.buscar();
        } catch (Exception e) {
            System.out.println("Nao foi possível obter dados de clientes...");
            return new ArrayList<>();
        }
    }

    public void criar(Cliente cliente) {
        try {
            this._clienteRepository.criar(cliente);
        } catch (Exception e) {
            System.out.println("Nao foi possível criar cliente...");
        }
    }

    public void atualizar(String clienteId, Cliente cliente) {
        try {
            this._clienteRepository.atualizar(clienteId, cliente);
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar cliente...");
        }
    }

    public void deletar(String clienteId) {
        try {
            this._clienteRepository.deletar(clienteId);
        } catch (Exception e) {
            System.out.println("Não foi possível deletar cliente...");
        }
    }
}

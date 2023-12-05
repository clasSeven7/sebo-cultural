package Infrastructure;

import Domain.Entities.Cliente;
import Domain.Entities.Endereco;
import Domain.Repositories.IClienteRepository;
import org.json.JSONObject;

import java.util.ArrayList;

public class ClienteRepository extends JSONRepository<Cliente> implements IClienteRepository {
    public ClienteRepository() {
        super(Cliente.class);
    }

    public ArrayList<Cliente> buscar() {
        return this.buscarDoJson();
    }

    public void criar(Cliente cliente) {
        var clientes = this.buscar();
        clientes.add(cliente);
        this.salvarNoJson(clientes);
    }

    public void deletar(String clienteId) {
        this.excluirNoJson(clienteId);
    }

    public void atualizar(String clienteId, Cliente cliente) {
        this.deletar(clienteId);
        this.criar(cliente);
    }

    @Override
    protected Cliente criarInstanciaAPartirDoJson(JSONObject jsonObject) {
        var enderecoObj = jsonObject.getJSONObject("endereco");
        return new Cliente(
                jsonObject.getString("id"),
                jsonObject.getString("nome"),
                jsonObject.getString("email"),
                new Endereco(
                        enderecoObj.getString("rua"),
                        enderecoObj.getString("cidade"),
                        enderecoObj.getString("estado"),
                        enderecoObj.getString("cep"),
                        enderecoObj.getString("pais")
                )
        );
    }

    @Override
    protected JSONObject criarJsonAPartirDaInstancia(Cliente entidade) {
        JSONObject jsonObject = new JSONObject();
        JSONObject enderecoJsonObj = new JSONObject();
        enderecoJsonObj.put("rua", entidade.getEndereco().getRua());
        enderecoJsonObj.put("cidade", entidade.getEndereco().getCidade());
        enderecoJsonObj.put("estado", entidade.getEndereco().getEstado());
        enderecoJsonObj.put("cep", entidade.getEndereco().getCep());
        enderecoJsonObj.put("pais", entidade.getEndereco().getPais());
        jsonObject.put("id", entidade.getId());
        jsonObject.put("nome", entidade.getNome());
        jsonObject.put("email", entidade.getEmail());
        jsonObject.put("endereco", enderecoJsonObj);
        return jsonObject;
    }

    @Override
    protected String getId(Cliente entidade) {
        return entidade.getId();
    }
}
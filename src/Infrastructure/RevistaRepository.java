package Infrastructure;

import Domain.Entities.Revista;
import Domain.Repositories.IRevistaRepository;
import org.json.JSONObject;

import java.util.ArrayList;

public class RevistaRepository extends JSONRepository<Revista> implements IRevistaRepository {
    public RevistaRepository() {
        super(Revista.class);
    }

    public ArrayList<Revista> buscar() {
        return this.buscarDoJson();
    }

    public void criar(Revista revista) {
        var revistas = this.buscar();
        revistas.add(revista);
        this.salvarNoJson(revistas);
    }

    public void deletar(String revistaId) {
        this.excluirNoJson(revistaId);
    }

    public void atualizar(String revistaId, Revista revista) {
        this.deletar(revistaId);
        this.criar(revista);
    }

    @Override
    protected Revista criarInstanciaAPartirDoJson(JSONObject jsonObject) {
        return new Revista(
                jsonObject.getString("id"),
                jsonObject.getString("titulo"),
                jsonObject.getString("autor"),
                jsonObject.getInt("anoPublicacao"),
                jsonObject.getString("editora")
        );
    }

    @Override
    protected JSONObject criarJsonAPartirDaInstancia(Revista entidade) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", entidade.getId());
        jsonObject.put("titulo", entidade.getTitulo());
        jsonObject.put("autor", entidade.getAutor());
        jsonObject.put("anoPublicacao", entidade.getAnoPublicacao());
        jsonObject.put("editora", entidade.getEditora());
        return jsonObject;
    }

    @Override
    protected String getId(Revista entidade) {
        return entidade.getId();
    }
}
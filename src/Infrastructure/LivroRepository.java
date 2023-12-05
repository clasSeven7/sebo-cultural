package Infrastructure;

import Domain.Entities.Livro;
import Domain.Repositories.ILivroRepository;
import org.json.JSONObject;

import java.util.ArrayList;

public class LivroRepository extends JSONRepository<Livro> implements ILivroRepository {
    public LivroRepository() {
        super(Livro.class);
    }

    public ArrayList<Livro> buscar() {
        return this.buscarDoJson();
    }

    public void criar(Livro livro) {
        var livros = this.buscar();
        livros.add(livro);
        this.salvarNoJson(livros);
    }

    public void deletar(String livroId) {
        this.excluirNoJson(livroId);
    }

    public void atualizar(String livroId, Livro livro) {
       this.deletar(livroId);
       this.criar(livro);
    }

    @Override
    protected Livro criarInstanciaAPartirDoJson(JSONObject jsonObject) {
        return new Livro(
                jsonObject.getString("id"),
                jsonObject.getString("titulo"),
                jsonObject.getString("genero"),
                jsonObject.getString("autor"),
                jsonObject.getInt("anoPublicacao"),
                jsonObject.getString("editora")
        );
    }

    @Override
    protected JSONObject criarJsonAPartirDaInstancia(Livro entidade) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", entidade.getId());
        jsonObject.put("titulo", entidade.getTitulo());
        jsonObject.put("genero", entidade.getGenero());
        jsonObject.put("autor", entidade.getAutor());
        jsonObject.put("anoPublicacao", entidade.getAnoPublicacao());
        jsonObject.put("editora", entidade.getEditora());
        return jsonObject;
    }

    @Override
    protected String getId(Livro entidade) {
        return entidade.getId();
    }
}
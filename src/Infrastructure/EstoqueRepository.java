package Infrastructure;

import Domain.Entities.*;
import Domain.Repositories.IEstoqueRepository;
import Shared.Utils.UniqueIdGenerator;
import org.json.JSONObject;

import java.util.ArrayList;

public class EstoqueRepository extends JSONRepository<ItemEstoque> implements IEstoqueRepository {
    public EstoqueRepository() {
        super(ItemEstoque.class);
    }

    public Estoque buscar() {
        var items = this.buscarDoJson();
        var estoque = new Estoque();

        for (ItemEstoque itemEstoque:items) {
            estoque.adicionar(itemEstoque.getItem(), itemEstoque.getQuantidade(), itemEstoque.getPreco());
        }

        return estoque;
    }

    public void salvar(ArrayList<ItemEstoque> items) {
        this.salvarNoJson(items);
    }

    @Override
    protected ItemEstoque criarInstanciaAPartirDoJson(JSONObject jsonObject) {
        var itemBibliotecaObject = jsonObject.getJSONObject("item");
        var itemBibliotecaType = itemBibliotecaObject.getEnum(TipoItemBiblioteca.class, "tipo");
        var itemBiblioteca = itemBibliotecaType == TipoItemBiblioteca.LIVRO
                ? new Livro(itemBibliotecaObject.getString("id"), itemBibliotecaObject.getString("titulo"),
                    itemBibliotecaObject.getString("genero"),
                    itemBibliotecaObject.getString("autor"),
                    itemBibliotecaObject.getInt("anoPublicacao"),
                    itemBibliotecaObject.getString("editora"))
                : new Revista(itemBibliotecaObject.getString("id"), itemBibliotecaObject.getString("titulo"),
                    itemBibliotecaObject.getString("genero"),
                    itemBibliotecaObject.getString("autor"),
                    itemBibliotecaObject.getInt("anoPublicacao"),
                    itemBibliotecaObject.getString("editora"));

        return new ItemEstoque(
                itemBiblioteca,
                jsonObject.getInt("quantidade"),
                jsonObject.getDouble("preco")
        );
    }

    @Override
    protected JSONObject criarJsonAPartirDaInstancia(ItemEstoque entidade) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("quantidade", entidade.getQuantidade());
        jsonObject.put("preco", entidade.getPreco());

        var itemBibliotecaJsonObject = new JSONObject();
        itemBibliotecaJsonObject.put("id", entidade.getItem().getId());
        itemBibliotecaJsonObject.put("titulo", entidade.getItem().getTitulo());
        itemBibliotecaJsonObject.put("tipo", entidade.getItem().getTipo());
        itemBibliotecaJsonObject.put("genero", entidade.getItem().getGenero());
        itemBibliotecaJsonObject.put("autor", entidade.getItem().getAutor());
        itemBibliotecaJsonObject.put("anoPublicacao", entidade.getItem().getAnoPublicacao());
        itemBibliotecaJsonObject.put("editora", entidade.getItem().getEditora());
        jsonObject.put("item", itemBibliotecaJsonObject);

        return jsonObject;
    }

    protected String getId(ItemEstoque entidade) {
        return UniqueIdGenerator.generate();
    }
}

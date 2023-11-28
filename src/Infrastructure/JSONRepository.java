package Infrastructure;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class JSONRepository<T> {
    public static final String DIRETORIO_DATABASE = "Database";
    public String ARQUIVO_JSON;
    private final Class<T> entityType;

    public JSONRepository(Class<T> entityType) {
        this.entityType = entityType;
        this.ARQUIVO_JSON = DIRETORIO_DATABASE + "/" + entityType.getSimpleName() + ".json";
    }

    public ArrayList<T> buscarDoJson() {
        try {
            Path filePath = Paths.get(this.ARQUIVO_JSON);

            if (!Files.exists(filePath)) return new ArrayList<>();

            var jsonString = Files.lines(filePath).collect(Collectors.joining());
            JSONArray jsonArray = new JSONArray(jsonString);

            ArrayList<T> entidades = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                T entidade = criarInstanciaAPartirDoJson(jsonObject);
                entidades.add(entidade);
            }

            return entidades;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void salvarNoJson(ArrayList<T> entidades) {
        JSONArray jsonArray = new JSONArray();
        for (T entidade : entidades) {
            JSONObject jsonObject = criarJsonAPartirDaInstancia(entidade);
            jsonArray.put(jsonObject);
        }

        try {
            Path directoryPath = Paths.get(DIRETORIO_DATABASE);
            if (Files.notExists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }

            Path filePath = Paths.get(this.ARQUIVO_JSON);
            Files.write(filePath, jsonArray.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excluirNoJson(String id) {
        ArrayList<T> entidades = buscarDoJson();
        entidades.removeIf(entidade -> getId(entidade).equals(id));
        salvarNoJson(entidades);
    }

    protected abstract T criarInstanciaAPartirDoJson(JSONObject jsonObject);

    protected abstract JSONObject criarJsonAPartirDaInstancia(T entidade);

    protected abstract String getId(T entidade);
}
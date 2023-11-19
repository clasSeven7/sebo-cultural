package Domain.Entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente extends Usuario {
    private ArrayList<String> generosFavoritos = new ArrayList<String>();
    private ArrayList<Pedido> historicoPedidos = new ArrayList<Pedido>();


    public Cliente(
            String nome,
            String email,
            Endereco endereco,
            ArrayList<String> generosFavoritos,
            ArrayList<Pedido> historicoPedidos
    ) {
        super();
        this.setNome(nome);
        this.setEmail(email);
        this.setPermissao(PermissaoUsuario.CLIENTE);
        this.setEndereco(endereco);
        this.setGenerosFavoritos(generosFavoritos);
        this.setHistoricoPedidos(historicoPedidos);
    }

    public ArrayList<Pedido> getHistoricoPedidos() {
        return this.historicoPedidos
                .stream()
                .sorted(Comparator.comparing(Pedido::getData).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> getGenerosFavoritos() {
        return this.generosFavoritos;
    }

    public void setGenerosFavoritos(ArrayList<String> generosFavoritos) {
        this.generosFavoritos = generosFavoritos;
    }

    public void setHistoricoPedidos(ArrayList<Pedido> historicoPedidos) {
        this.historicoPedidos = historicoPedidos;
    }

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

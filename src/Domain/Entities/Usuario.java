package Domain.Entities;

import Shared.Utils.UniqueIdGenerator;

public abstract class Usuario {
    private String id;
    private String nome;
    private String email;
    private PermissaoUsuario permissao;

    public Usuario() {
        this.id = UniqueIdGenerator.generate();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PermissaoUsuario getPermissao() {
        return permissao;
    }

    public void setPermissao(PermissaoUsuario permissao) {
        this.permissao = permissao;
    }
}

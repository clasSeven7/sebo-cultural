package Domain.Entities;

public abstract class Usuario extends Entidade {
    private String nome;
    private String email;
    private PermissaoUsuario permissao;

    private Endereco endereco;

    public Usuario() {
        super();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PermissaoUsuario getPermissao() {
        return this.permissao;
    }

    public void setPermissao(PermissaoUsuario permissao) {
        this.permissao = permissao;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

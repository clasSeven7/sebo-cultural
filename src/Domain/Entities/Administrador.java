package Domain.Entities;

public class Administrador extends Usuario {
    public Administrador(
            String nome,
            String email,
            Endereco endereco
    ) {
        super();
        this.setNome(nome);
        this.setEmail(email);
        this.setPermissao(PermissaoUsuario.ADMINISTRADOR);
        this.setEndereco(endereco);
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id='" + this.getId() + '\'' +
                ", nome=" + this.getNome() +
                ", email='" + this.getEmail() + '\'' +
                ", permissao='" + this.getPermissao() + '\'' +
                ", endereco='" + this.getEndereco().toString() + '\'' +
                '}';
    }
}

package Domain.Entities;

public class Cliente extends Usuario {
    public Cliente(
            String nome,
            String email,
            Endereco endereco
    ) {
        super();
        this.setNome(nome);
        this.setEmail(email);
        this.setPermissao(PermissaoUsuario.CLIENTE);
        this.setEndereco(endereco);
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

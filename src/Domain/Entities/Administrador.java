/**
 * A classe `Administrador` representa um usuário administrador no sistema,
 * estendendo a classe base `Usuario`.
 *
 * Esta classe inclui atributos e métodos específicos relacionados a usuários administradores.
 */

package Domain.Entities;

/**
 * Construtor para criar uma instância da classe `Administrador`.
 *
 * @param nome     O nome do administrador.
 * @param email    O endereço de e-mail do administrador.
 * @param endereco O endereço do administrador.
 */
public class Administrador extends Usuario {
    public Administrador(
            String nome,
            String email,
            Endereco endereco
    ) {
        super(); // Chama o construtor da classe base (Usuario).
        this.setNome(nome);
        this.setEmail(email);
        this.setPermissao(PermissaoUsuario.ADMINISTRADOR);
        this.setEndereco(endereco);
    }

    /**
     * Retorna uma representação em string do objeto `Administrador`.
     *
     * @return Uma string contendo informações sobre o administrador.
     */
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

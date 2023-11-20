package testes;

import Domain.Entities.Administrador;
import Domain.Entities.Endereco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdministradorTest {

    @Test
    public void testToString() {
        // Arrange
        String nome = "John Doe";
        String email = "john.doe@example.com";
        Endereco endereco = new Endereco(
                "Rua dos Bobos",
                "Patos",
                "PB",
                "570000",
                "Brasil");

        Administrador administrador = new Administrador(nome, email, endereco);

        // Act
        String result = administrador.toString();

        // Assert
        String expected = "Administrador{" +
                "id='" + administrador.getId() + '\'' +
                ", nome=" + administrador.getNome() +
                ", email='" + administrador.getEmail() + '\'' +
                ", permissao='" + administrador.getPermissao() + '\'' +
                ", endereco='" + administrador.getEndereco().toString() + '\'' +
                '}';
        assertEquals(expected, result);
    }

}

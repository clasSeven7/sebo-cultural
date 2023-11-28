package Tests;

import Domain.Entities.Endereco;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EnderecoTest {

    @Test
    public void testEnderecoGettersAndSetters() {
        // Arrange
        String rua = "Rua Teste";
        String cidade = "Cidade Teste";
        String estado = "Estado Teste";
        String cep = "12345-678";
        String pais = "Pais Teste";

        // Act
        Endereco endereco = new Endereco(rua, cidade, estado, cep, pais);

        // Assert
        assertEquals(rua, endereco.getRua());
        assertEquals(cidade, endereco.getCidade());
        assertEquals(estado, endereco.getEstado());
        assertEquals(cep, endereco.getCep());
        assertEquals(pais, endereco.getPais());
    }

    @Test
    public void testEnderecoToString() {
        // Arrange
        String rua = "Rua Teste";
        String cidade = "Cidade Teste";
        String estado = "Estado Teste";
        String cep = "12345-678";
        String pais = "Pais Teste";

        // Act
        Endereco endereco = new Endereco(rua, cidade, estado, cep, pais);

        // Assert
        String expectedToString = "Endereco{" +
                "rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", pais='" + pais + '\'' +
                '}';
        assertEquals(expectedToString, endereco.toString());
    }
}

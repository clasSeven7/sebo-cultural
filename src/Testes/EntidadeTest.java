package Testes;

import Domain.Entities.Entidade;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntidadeTest {

    // Classe de teste concreta para Entidade
    private static class EntidadeTestImpl extends Entidade {
    }

    @Test
    public void testUniqueIdGeneration() {
        // Arrange
        EntidadeTestImpl entidade = new EntidadeTestImpl();

        // Act
        String generatedId = entidade.getId();

        // Assert
        assertNotNull(generatedId);
        assertNotEquals("", generatedId); // Verifica se o ID não está vazio
        assertFalse(generatedId.isEmpty()); // Verifica se o ID tem comprimento positivo
    }

    @Test
    public void testUniqueIdUniqueness() {
        // Arrange
        EntidadeTestImpl entidade1 = new EntidadeTestImpl();
        EntidadeTestImpl entidade2 = new EntidadeTestImpl();

        // Act
        String id1 = entidade1.getId();
        String id2 = entidade2.getId();

        // Assert
        assertNotEquals(id1, id2); // Verifica se os IDs são diferentes
    }

    @Test
    public void testUniqueIdFormat() {
        // Arrange
        EntidadeTestImpl entidade = new EntidadeTestImpl();

        // Act
        String generatedId = entidade.getId();

        // Assert
        assertTrue(generatedId.matches("[a-f0-9]{8}-([a-f0-9]{4}-){3}[a-f0-9]{12}"));
    }
}

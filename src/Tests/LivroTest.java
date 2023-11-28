package Tests;

import Domain.Entities.ItemBiblioteca;
import Domain.Entities.Livro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroTest {

    @Test
    public void testSetTitulo() {
        ItemBiblioteca item = new Livro("123", "Livro Teste", "Autor Teste", 2023, "Editora Teste");
        assertEquals("123", item.getTitulo());
    }
}

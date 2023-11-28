package Testes;

import Domain.Entities.ItemBiblioteca;
import Domain.Entities.TipoItemBiblioteca;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemBibliotecaTest extends EntidadeTest {
    @Test
    public void testSetTitulo() {
        ItemBiblioteca item = new ItemBiblioteca("123", "Livro Teste", "Autor Teste", "Editora Teste");
        item.setTitulo("Novo Livro");
        assertEquals("Novo Livro", item.getTitulo());
    }

    @Test
    public void testGetGenero() {
        ItemBiblioteca item = new ItemBiblioteca("123", "Livro Teste", "Autor Teste", "Editora Teste");
        assertNull(item.getGenero()); // Assuming the default value is null, you can modify accordingly
    }

    @org.junit.Test
    public void testGetAutor() {
        ItemBiblioteca item = new ItemBiblioteca("123", "Livro Teste", "Autor Teste", "Editora Teste");
        item.setAutor("Novo Autor");
        assertEquals("Novo Autor", item.getAutor());
    }

    @org.junit.Test
    public void testGetAnoPublicacao() {
        ItemBiblioteca item = new ItemBiblioteca("123", "Livro Teste", "Autor Teste", "Editora Teste");
        item.setAnoPublicacao(2020);
        assertEquals(2020, item.getAnoPublicacao());
    }

    @org.junit.Test
    public void testGetEditora() {
        ItemBiblioteca item = new ItemBiblioteca("123", "Livro Teste", "Autor Teste", "Editora Teste");
        item.setEditora("Nova Editora");
        assertEquals("Nova Editora", item.getEditora());
    }

    @Test
    public void testTipoItemBiblioteca() {
        ItemBiblioteca item = new ItemBiblioteca("123", "Livro Teste", "Autor Teste", "Editora Teste");
        item.setTipo(TipoItemBiblioteca.LIVRO);
        assertEquals(TipoItemBiblioteca.LIVRO, item.getTipo());

    }
}

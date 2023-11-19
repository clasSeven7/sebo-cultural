package Domain.Entities;

import Shared.Utils.UniqueIdGenerator;

public abstract class ItemBiblioteca {
    private String id;
    private String titulo;
    private String genero;
    private String autor;
    private int anoPublicacao;
    private String editora;
    private TipoItemBiblioteca tipo;

    public ItemBiblioteca() {
        this.id = UniqueIdGenerator.generate();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getId() {
        return this.id;
    }

    public TipoItemBiblioteca getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoItemBiblioteca tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return this.editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}

package Domain.Entities;

public abstract class ItemBiblioteca extends Entidade {
    private String titulo;
    private String genero;
    private String autor;
    private int anoPublicacao;
    private String editora;
    private TipoItemBiblioteca tipo;


    public ItemBiblioteca() {
        super();
    }


    /**
     * Obtém o título do item bibliotecário.
     *
     * @return O título do item.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Define o título do item bibliotecário.
     *
     * @param titulo Novo título do item.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtém o gênero do item bibliotecário.
     *
     * @return O gênero do item.
     */

    public String getGenero() {
        return this.genero;
    }



    public void setGenero(String genero) {
        this.genero = genero;
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

package Domain.Entities;

public class Livro extends ItemBiblioteca {
    public Livro(
            String titulo,
            String genero,
            String autor,
            int anoPublicacao,
            String editora
    ) {
        this.setTipo(TipoItemBiblioteca.LIVRO);
        this.setTitulo(titulo);
        this.setGenero(genero);
        this.setAutor(autor);
        this.setAnoPublicacao(anoPublicacao);
        this.setEditora(editora);
    }

    public Livro(
            String id,
            String titulo,
            String genero,
            String autor,
            int anoPublicacao,
            String editora
    ) {
        this.setId(id);
        this.setTipo(TipoItemBiblioteca.LIVRO);
        this.setTitulo(titulo);
        this.setGenero(genero);
        this.setAutor(autor);
        this.setAnoPublicacao(anoPublicacao);
        this.setEditora(editora);
    }


    public Livro(Livro livro, int quantidadeLivro, double precoLivro) {
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id='" + this.getId() + '\'' +
                ", tipo=" + this.getTipo() +
                ", titulo='" + this.getTitulo() + '\'' +
                ", genero='" + this.getGenero() + '\'' +
                ", autor='" + this.getAutor() + '\'' +
                ", anoPublicacao=" + this.getAnoPublicacao() +
                ", editora='" + this.getEditora() + '\'' +
                '}';
    }
}

package Domain.Entities;

public class Revista extends ItemBiblioteca {
    public Revista(
            String titulo,
            String genero,
            String autor,
            int anoPublicacao,
            String editora
    ) {
        this.setTipo(TipoItemBiblioteca.REVISTA);
        this.setTitulo(titulo);
        this.setGenero(genero);
        this.setAutor(autor);
        this.setAnoPublicacao(anoPublicacao);
        this.setEditora(editora);
    }

    @Override
    public String toString() {
        return "Revista{" +
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

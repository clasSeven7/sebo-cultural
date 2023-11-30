package Domain.Entities;

public class Endereco {
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    /**
     * Construtor para criar uma instância de {@code Endereco} com as informações fornecidas.
     *
     * @param rua    O nome da rua.
     * @param cidade A cidade.
     * @param estado O estado.
     * @param cep    O CEP (Código de Endereçamento Postal).
     * @param pais   O país.
     */

    public Endereco(
            String rua,
            String cidade,
            String estado,
            String cep,
            String pais
    ) {
        this.setRua(rua);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setCep(cep);
        this.setPais(pais);
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Retorna uma representação em formato de string do objeto {@code Endereco}.
     *
     * @return Uma string que representa o endereço, incluindo rua, cidade, estado, CEP e país.
     */

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

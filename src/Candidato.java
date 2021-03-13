public class Candidato {

    private String nome;
    private Integer quantidadeVotos;

    public Candidato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getQuantidadeVotos() {
        return quantidadeVotos;
    }

    public void setQuantidadeVotos(Integer quantidadeVotos) {
        this.quantidadeVotos = quantidadeVotos;
    }
}

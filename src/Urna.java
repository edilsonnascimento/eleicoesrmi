import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Urna implements Serializable {

    private List<Candidato> candidatos = new ArrayList<>();
    private Integer votosTotal;

    public Urna() {
        this.votosTotal = 0;
        carregaCandidatos();
        simulaVotacao();
    }

    private static void accept(Candidato candidato) {
        System.out.println(candidato.getNome() + " = " + candidato.getQuantidadeVotos());
    }

    private void carregaCandidatos(){
        this.candidatos.add(new Candidato("Gandalf"));
        this.candidatos.add(new Candidato("Frodo Bolseiro"));
        this.candidatos.add(new Candidato("Samwise Gamgee"));
        System.out.println("Candidatos Carregados na URNA...");
    }

    public void simulaVotacao(){
        Random gerador = new Random();
        this.candidatos.get(0).setQuantidadeVotos(gerador.nextInt(100));
        this.candidatos.get(1).setQuantidadeVotos(gerador.nextInt(100));
        this.candidatos.get(2).setQuantidadeVotos(gerador.nextInt(100));
        votosTotal = this.SomaVotos();
        System.out.println("Votos da URNA: " + votosTotal);

    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void mostrarUrna(){
        this.candidatos.forEach(Urna::accept);
        System.out.println("----------------------------------------------------------");
        System.out.println("Total de votos: " + this.votosTotal);
        System.out.println("----------------------------------------------------------\n");
    }

    public Integer getVotosTotal() {
        return votosTotal;
    }

    private Integer SomaVotos(){
        return  this.candidatos
                .parallelStream()
                .mapToInt(c -> c.getQuantidadeVotos())
                .sum();
    }
}

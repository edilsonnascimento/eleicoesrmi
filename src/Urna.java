import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Urna {

    private List<Candidato> candidatos = new ArrayList<>();

    public Urna() {
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
        System.out.println("Votos apurados...");

    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void mostraCandidatos(){
        this.candidatos.forEach(Urna::accept);
    }

}

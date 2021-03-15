import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ServidorEleicaoImplemets implements Eleicao{

    private static Integer votosApurados = 0;
    private static Integer codigoUrna = 1;

    @Override
    public String testaConexao() {
        return "Olá cliente!";
    }

    @Override
    public void somaVotos(Integer quantidadeVotos) throws RemoteException {
        votosApurados = votosApurados + quantidadeVotos;
    }

    @Override
    public void recebeVotos(Urna urna) throws RemoteException {
        System.out.println("----------------------------------------------------------");
        System.out.println("URNA RECEBIDA...");
        System.out.println("Codigo da Urna: " + codigoUrna++);
        urna.mostrarUrna();
        somaVotos(urna.getVotosTotal());
    }

    public static void main(String[] args) {
        try {

            ServidorEleicaoImplemets servidor = new ServidorEleicaoImplemets();
            Eleicao stub = (Eleicao) UnicastRemoteObject.exportObject(servidor,0);

            Registry registro = LocateRegistry.createRegistry(1099);
            registro.bind("eleicoes", stub);

            System.out.println("Servidor de Eleições up...");

            String horaAtual = "";
            while(true){
                Thread.sleep(5000);
                horaAtual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss"));
                System.out.println("==========================================================");
                System.out.println("TOTAL VOTOS APURADOS");
                System.out.println("Data e hora: " + horaAtual + " quantidade de votos: " + votosApurados);
                System.out.println("========================================================== \n");
            }

        }catch (Exception e){
            System.out.println("Problemana na execução do servidor RMI!");
        }
    }
}

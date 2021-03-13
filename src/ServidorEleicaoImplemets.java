import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ServidorEleicaoImplemets implements Eleicao{

    @Override
    public String testaConexao() {
        return "Olá cliente!";
    }

    public static void main(String[] args) {
        try {

            ServidorEleicaoImplemets servidor = new ServidorEleicaoImplemets();
            Eleicao stub = (Eleicao) UnicastRemoteObject.exportObject(servidor,0);

            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            registro.bind("eleicoes", stub);

            System.out.println("Servidor de Eleições up...");

        }catch (Exception e){
            System.out.println("Problemana na execução do servidor RMI!");
        }
    }
}

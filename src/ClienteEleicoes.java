import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteEleicoes {

    public static void main(String[] args) {

        try {

             Registry regitro = LocateRegistry.getRegistry("localhost", 1099);

             Eleicao stub = (Eleicao) regitro.lookup("eleicoes");

             Urna urna = new Urna();

            System.out.println(stub.testaConexao());

            stub.recebeVotos(urna);


        }catch (Exception e){
            System.out.println("Erro ao se conectar com o servidor");
            e.printStackTrace();
        }
    }
}

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteEleicoes {

    public static void main(String[] args) {

        try {

             Registry regitro = LocateRegistry.getRegistry("localhost", 1099);

             Eleicao stub = (Eleicao) regitro.lookup("eleicoes");

            System.out.println(stub.testaConexao());


        }catch (Exception e){
            System.out.println("Erro ao se conectar com o servidor");
        }
    }
}

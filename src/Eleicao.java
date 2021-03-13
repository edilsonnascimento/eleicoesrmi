import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Eleicao extends Remote {

       String testaConexao() throws RemoteException;
}

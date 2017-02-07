/**
 * Created by alice on 06/02/17.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameInterface extends Remote {
    void setnPlayers(int nPlayers) throws RemoteException;
    boolean isGotPlayers() throws RemoteException;
    void waitServer() throws RemoteException;
    void waitClient() throws RemoteException;
}

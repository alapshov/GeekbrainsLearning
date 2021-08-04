import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Server {

    private static final int PORT = 8090;

    public void start(){
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server start.....");
            while (true){
                System.out.println("Waiting for connection.....");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.....");
                new Handler(socket).handle();
            }
        }
        catch (IOException e){

        };
    }

}

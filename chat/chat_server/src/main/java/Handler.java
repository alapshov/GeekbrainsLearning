import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Handler {

    private static int clientCounter = 0;
    private int clientNumber;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Thread handlerThread;
    private static Vector<Socket> sockets = new Vector<>();

    public Handler(Socket socket) {
        try {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Handler created.....");
            this.clientNumber = ++clientCounter;
            sockets.add(socket);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handle() {
        handlerThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
                try {
                    String message = in.readUTF();
                    System.out.printf("Client #%d: %s\n", this.clientNumber, message);
                    for (Socket socketOut : sockets) {
                        DataOutputStream out = new DataOutputStream(socketOut.getOutputStream());
                        out.writeUTF("Client # " + this.clientNumber + " "+ message);
                    }

                } catch (IOException e) {
                    e.printStackTrace();

                }
            }
        });
        handlerThread.start();

    }

}

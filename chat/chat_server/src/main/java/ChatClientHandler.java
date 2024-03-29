import error.UserNotFoundException;
import error.WrongCredentialsException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ChatClientHandler {
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    //private Thread handlerThread;
    private ExecutorService handlerThread;
    private Server server;
    private String currentUser;


    public ChatClientHandler(Socket socket, Server server) {
        try {
            handlerThread = Executors.newFixedThreadPool(12);
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Handler created");
            this.server = server;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle() {
        handlerThread.execute(() -> {
            authorize();
            try {
                while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
                    String message = in.readUTF();
                    System.out.printf("Client #%s: %s\n", this.currentUser, message);
                    server.privateMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                server.removeAuthorizedClientFromList(this);
            }
        });
        handlerThread.shutdown();
    }


    private void authorize() {
        while (true) {
            try {
                String message = in.readUTF();
                if (message.startsWith("auth:")) {
                    String[] credentials = message.substring(6).split("\\s");
                    try {
                        this.currentUser = server.getAuthService().getNicknameByLoginAndPassword(credentials[0], credentials[1]);
                        this.server.addAuthorizedClientToList(this);
                        sendMessage("authok: " + this.currentUser);
                        break;
                    } catch (WrongCredentialsException e) {
                        sendMessage("ERROR: Wrong credentials");
                    } catch (UserNotFoundException e) {
                        sendMessage("ERROR: User not found!");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public Thread getHandlerThread() {
//        return handlerThread;
//    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void sendMessage(String message) {
        try {
            this.out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import auth.AuthService;
import auth.InMemoryAuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final int PORT = 8089;
    private AuthService authService;
    private List<ChatClientHandler> chatClientHandlers;

    public Server() {
        this.authService = new InMemoryAuthService();
        this.chatClientHandlers = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server start!");
            while (true) {
                System.out.println("Waiting for connection......");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                new ChatClientHandler(socket, this).handle();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        for (ChatClientHandler handler : chatClientHandlers) {
            handler.sendMessage(message);
        }
    }

    public synchronized void removeAuthorizedClientFromList(ChatClientHandler handler) {
        this.chatClientHandlers.remove(handler);
        sendClientsOnline();
    }

    public synchronized void addAuthorizedClientToList(ChatClientHandler handler) {
        this.chatClientHandlers.add(handler);
        sendClientsOnline();
    }
    public AuthService getAuthService() {
        return authService;
    }

    public void sendClientsOnline() {
        StringBuilder sb = new StringBuilder("$.list: ");
        for (ChatClientHandler handler : chatClientHandlers) {
            sb.append(handler.getCurrentUser()).append(" ");
        }
        broadcastMessage(sb.toString());
    }

}

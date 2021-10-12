import auth.AuthService;
import auth.InMemoryAuthService;
import auth.JDBCAuthService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static final int PORT = 5347;
    private AuthService authService;
    private List<ChatClientHandler> chatClientHandlers;
    private ChatClientHandler clientHandler;
    private static final Logger LOGGER = LogManager.getLogger(Server.class);



    public Server() {
        this.authService = new JDBCAuthService();
        this.chatClientHandlers = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server start!");
            LOGGER.info("Server start!");
            while (true) {
                System.out.println("Waiting for connection......");
                LOGGER.info("Waiting for connection......");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                LOGGER.info("Client connected");
                clientHandler = new ChatClientHandler(socket, this);
                clientHandler.handle();
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

    public void privateMessage(String message) {
        for (ChatClientHandler handler : chatClientHandlers) {
            if(message.startsWith(handler.getCurrentUser())) {
                message = message.split(":", 2)[1];
                handler.sendMessage(message);
            }
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

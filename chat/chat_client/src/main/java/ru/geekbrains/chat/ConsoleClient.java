package ru.geekbrains.chat;

import java.io.*;
import java.net.Socket;

public class ConsoleClient {
    private static final String HOST = "localhost";
    private static final int PORT = 5347;
    private DataOutputStream out;
    private DataInputStream in;
    private Thread clientConsoleThread;


    public static void main(String[] args) {
        new ConsoleClient().start();
    }

    public void start() {
        try (Socket socket = new Socket(HOST, PORT)) {
            System.out.println("Client started!");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            startClientConsoleThread();

            while (true) {
                String message = in.readUTF();
                if (message.startsWith("/end")) {
                    shutdown();
                    break;
                }
                System.out.println("Received: " + message);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void shutdown() throws IOException {
        if (clientConsoleThread.isAlive()) clientConsoleThread.interrupt();
        System.out.println("Client stopped");
    }

    private void startClientConsoleThread() {
        clientConsoleThread = new Thread(() -> {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.print("Enter message for server >>>> \n");

                while (!Thread.currentThread().isInterrupted()) {
                    if (bufferedReader.ready()) {
                        String serverMessage = bufferedReader.readLine();
                        out.writeUTF(serverMessage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        clientConsoleThread.start();
    }
}

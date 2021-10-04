package ru.geekbrains.chat.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LogService {

    private static File file;

    public static String readChatLog(String name) {
        String fileName = name + ".txt";
        String message = null;
        byte[] buf = new byte[20];
        try(FileInputStream in = new FileInputStream(fileName)){
            int count;
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    message += (char) buf[i];
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return message;
    }

    public static void writeChatLog(String name, String message) {
        String fileName = name + ".txt";
        file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try(FileOutputStream out = new FileOutputStream(fileName, true)){
            out.write(message.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

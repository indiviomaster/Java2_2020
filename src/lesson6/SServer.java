package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SServer {
    private static final int SERVER_PORT = 8090;

    public static void main(String[] args) {
        Socket socket;

        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)){
            System.out.println("Сервер запущен");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new ScanAndSend(out);
            String str;

            while(true){
                str = in.readUTF();
                if(str != null)
                {
                    System.out.println("From client: "+str);
                    str = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
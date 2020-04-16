package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SClient {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8090;

    public static void main(String[] args) {
        String str;
        try{
            Socket socket = new Socket(SERVER_ADDR,SERVER_PORT);
            System.out.println("Подключился к серверу");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new ScanAndSend(out);
            while(true){

                str = in.readUTF();
                if(str != null){

                System.out.println("From server: "+str);
                str = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
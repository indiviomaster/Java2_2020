package lesson6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScanAndSend implements Runnable {
        Thread thread;
        Scanner scanner;
        String msgStr;
        DataOutputStream outStream;
        ScanAndSend(DataOutputStream ot) throws IOException {
            this.outStream = ot;
            scanner = new Scanner(System.in);
            thread = new Thread(this,"Answer thread");
            thread.start();
        }
        @Override
        public void run() {
            while (true){
                msgStr = scanner.nextLine();
                if(msgStr!=null){
                    try {
                        outStream.writeUTF(msgStr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


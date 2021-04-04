package BIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String next = scanner.next();
                socket.getOutputStream().write(next.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

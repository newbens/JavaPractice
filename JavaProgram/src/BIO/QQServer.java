package BIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {
    static byte[] bytes = new byte[1024];
    public static void main(String[] args) {
        try {
            //用于监听
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));
            System.out.println("等待连接");
            while (true) {
                //阻塞
                Socket socket = serverSocket.accept();
                System.out.println("连接成功，等待数据");
                //阻塞
                int len = socket.getInputStream().read(bytes);
                System.out.println("数据接收成功！");
                String s = new String(bytes);
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

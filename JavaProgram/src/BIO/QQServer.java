package BIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class QQServer {
    static byte[] bytes = new byte[1024];
    public static void main(String[] args) {
        try {
            //���ڼ���
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));
            System.out.println("�ȴ�����");
            while (true) {
                //����
                Socket socket = serverSocket.accept();
                System.out.println("���ӳɹ����ȴ�����");
                //����
                int len = socket.getInputStream().read(bytes);
                System.out.println("���ݽ��ճɹ���");
                String s = new String(bytes);
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class TestNonBlockingNIO2 {
    @Test
    public void send() throws IOException {
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        ByteBuffer bf = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            bf.put((LocalDateTime.now() + "\t" + str).getBytes());
            bf.flip();
            dc.send(bf, new InetSocketAddress("127.0.0.1", 9898));
            bf.clear();
        }
        dc.close();
    }

    @Test
    public void receive() throws IOException {
        DatagramChannel dc = DatagramChannel.open();
        dc.bind(new InetSocketAddress(9898));
        dc.configureBlocking(false);
        Selector selector = Selector.open();
        dc.register(selector, SelectionKey.OP_READ);
        while (selector.select() > 0) {
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey next = keys.next();
                if (next.isReadable()) {
                    ByteBuffer bf = ByteBuffer.allocate(1024);
                    dc.receive(bf);
                    bf.flip();
                    System.out.println(new String(bf.array(),0,bf.limit()));
                    bf.clear();
                }
            }
            keys.remove();
        }
    }

}

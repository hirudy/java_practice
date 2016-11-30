package MyNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author: rudy
 * @date: 2016/11/06
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8888));
//        ssc.configureBlocking(false);
        String hello_string = "hello rudy!";
        ByteBuffer buffer = ByteBuffer.wrap(hello_string.getBytes());
        while (true){
//            System.out.println("wait for connections");
            SocketChannel clientSocket = ssc.accept();
            if (null == clientSocket){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println(String.format("incomimg connection from: %s",clientSocket.getRemoteAddress()));
                buffer.rewind();
                clientSocket.write(buffer);
                clientSocket.close();
            }
        }
    }
}

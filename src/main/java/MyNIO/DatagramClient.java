package MyNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author: rudy
 * @date: 2016/11/07
 */
public class DatagramClient {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        String sendData = "哈哈哈 hello rudy!";
        ByteBuffer buffer = ByteBuffer.wrap(sendData.getBytes());
        channel.send(buffer, new  InetSocketAddress("localhost",8888));
        System.out.println("send end!");
    }
}

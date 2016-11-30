package ProvingGround;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/**
 * @author: rudy
 * @date: 2016/10/26
 */
public class Test {


    public static void main(String[] args) throws Exception {
        Path path = Paths.get(System.getProperty("user.dir"));
        Path conf = path.resolve("conf/CensorWords.txt");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        FileChannel channel = FileChannel.open(conf,StandardOpenOption.READ);
        channel.read(buffer, channel.size()-100);
        channel.close();
        System.out.println(buffer.flip());
        System.out.println("end");
    }
}

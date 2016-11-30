package MyAIO;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;

/**
 * @author: rudy
 * @date: 2016/11/30
 */
public class FileUtil {

    public static void readFileFuture() throws Exception{
        Path path = Paths.get("/data/code/github/java_practice/src/main/resources/1log4j.properties");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> future = channel.read(buffer,0);
//        while (!future.isDone()){
//            System.out.println("I'm idle");
//        }
        Integer readNumber = future.get();

        buffer.flip();
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
        decoder.decode(buffer,charBuffer,false);
        charBuffer.flip();
        String data = new String(charBuffer.array(),0, charBuffer.limit());
        System.out.println("read number:" + readNumber);
        System.out.println(data);
    }


    public static void readFileCallback() throws Exception{
        Path path = Paths.get("/data/code/github/java_practice/src/main/resources/1log4j.properties");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(Thread.currentThread().getName() + " read success!");
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("read error");
            }
        });

        while (true){
            System.out.println(Thread.currentThread().getName() + " sleep");
            Thread.sleep(1000);
        }
    }

    @Test
    public void testReadFileFuture() throws Exception {
        readFileFuture();
    }

    @Test(timeout = 2000)
    public void testReadFileCallback() throws Exception {
        readFileCallback();
    }
}

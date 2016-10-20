package DesignPattern.Two;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 订阅的消息
 */

public class Message {
    private String content;
    private static AtomicInteger counter = new AtomicInteger(0);

    private Message(){
        content = "message_" + counter.incrementAndGet();
    }

    public static Message getMessage(){
        return new Message();
    }

    public String getContent(){
        return content;
    }
}

package MyThread;

import org.apache.log4j.PropertyConfigurator;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: rudy
 * @date: 2016/10/12
 * <p>
 * function description
 */

public class OneThread extends Thread {
    private static AtomicInteger nextThreadId = new AtomicInteger(0);

    private static ThreadGroup myGroup = new ThreadGroup("OneThreadGroup");

//    private static AtomicInteger count = new AtomicInteger(0);
    private static Integer Mycount = 0;

    public static final Map<String,Integer> result = new TreeMap<>();

    private int threadId = 0;

    private static Object object = new Object();

    public OneThread(){
        super(myGroup,"OneThread");
        threadId = nextThreadId.incrementAndGet();
        String name = this.getClass().getSimpleName() + "-thread"+threadId;
        this.setName(name);
//        this.setDaemon(true);
        this.setUncaughtExceptionHandler(new ThreadUncaughtExceptionHandler());
    }

    public void run(){
        int whileCount = 0;
        while (!isInterrupted()){
            try {
                whileCount ++;
                int sleepTime = (int)(3+Math.random()*2);
//                int temp = count.incrementAndGet();

                int temp = 0;

                synchronized (Mycount){
                    Mycount = Mycount + 1;
                    temp = Mycount;
                    result.put(threadId + "_" + whileCount,temp);
                }


//                System.out.println(this.getName()+" count:" + temp);
                sleep(sleepTime*100);

            } catch (InterruptedException e) {
//                e.printStackTrace();
                break;
            }
        }
        System.out.println(this.getName() + " end!");
    }
}

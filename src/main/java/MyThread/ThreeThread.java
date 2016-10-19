package MyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: rudy
 * @date: 2016/10/13
 * <p>
 * function description
 */
public class ThreeThread extends Thread {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static int count = 0;
    public static final List<Integer> result = new ArrayList<>();

    public void run(){

        for(int i=0; i< 10; i++){
            lock.lock();
            try{
                count ++;
                result.add(count);
            }finally {
                lock.unlock();
            }
        }
    }
}

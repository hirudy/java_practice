package MyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: rudy
 * @date: 2016/10/13
 * <p>
 * function description
 */
public class TwoThread extends Thread {

    private static Integer count = 0;
    public static final List<Integer> result = new ArrayList<>();

    public void run(){

        for(int i=0; i< 10; i++){
            synchronized (count) {  // error, 每一次的Integer ++ 都会创建一个新对象.所以达不到要求
                count ++;
                result.add(count);
            }
        }
    }
}

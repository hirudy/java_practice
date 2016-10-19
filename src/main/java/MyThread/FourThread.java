package MyThread;

import java.util.concurrent.*;

/**
 * @author: rudy
 * @date: 2016/10/13
 * <p>
 * function description
 */


class TaskCall implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("aaaaa");
        return 1;
    }
}

public class FourThread {
    public static void run() throws ExecutionException, InterruptedException {
        Callable<Integer> call = new TaskCall();
        FutureTask<Integer> task = new FutureTask<>(call);
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        poolExecutor.submit(task);
        int temp = task.get();
        System.out.println(temp);
    }
}

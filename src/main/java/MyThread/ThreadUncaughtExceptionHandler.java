package MyThread;

import org.apache.log4j.Logger;

/**
 * @author: rudy
 * @date: 2016/10/12
 * <p>
 * function description
 */
public class ThreadUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static Logger logger = Logger.getRootLogger();

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        logger.error(t.getName()+"| death| " , e);
        System.exit(0);
    }
}

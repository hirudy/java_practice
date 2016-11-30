package DesignPattern.Five;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 控制台日志打印
 */
public class ConsoleLogger {
    private static volatile ConsoleLogger logger;

    private ConsoleLogger(){
    }

    // 单例
    public static ConsoleLogger getInstance(){
        if (logger == null){
            synchronized (ConsoleLogger.class){
                if (logger == null){
                    logger = new ConsoleLogger();
                }
            }
        }
        return logger;
    }


    public void log(String message){
        System.out.println("[ info ] " + message);
    }
}

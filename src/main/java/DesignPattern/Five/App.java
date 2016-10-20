package DesignPattern.Five;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 单例模式,比较简单
 */
public class App {

    public static void main(String[] args){
        ConsoleLogger.getInstance().log("hello rudy!");
        ConsoleLogger.getInstance().log("同一个logger对象!");
    }
}

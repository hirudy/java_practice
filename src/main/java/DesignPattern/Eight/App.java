package DesignPattern.Eight;

/**
 * @author: rudy
 * @date: 2016/10/21
 *
 * 外观模式: 简化接口,自然而然的.
 */
public class App {

    public static void main(String[] args){
        Manager manager = new Manager();
        manager.start();
        manager.middle();
        manager.end();
    }
}

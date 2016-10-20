package DesignPattern.One;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 策略模式, 实例如鸭子的故事
 */
public class App {
    public static void main(String[] args){
        Duck normalDuck = new NormalDuck();
        Duck rubberDuck = new RubberDuck();

        System.out.println("normal duck:");
        normalDuck.performFlyBehaviour();
        normalDuck.performQuackBehaviour();

        System.out.println("rubber duck:");
        rubberDuck.performFlyBehaviour();
        rubberDuck.performQuackBehaviour();
    }
}

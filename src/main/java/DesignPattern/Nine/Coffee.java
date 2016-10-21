package DesignPattern.Nine;

/**
 * @author: rudy
 * @date: 2016/10/21
 *
 * 咖啡制造过程
 */
public class Coffee extends Beverage {
    @Override
    public void make() {
        System.out.println("磨咖啡");
    }

    @Override
    public void condiment() {
        System.out.println("加糖,喝咖啡");
    }
}

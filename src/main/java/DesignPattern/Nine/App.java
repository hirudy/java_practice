package DesignPattern.Nine;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 模板方法模式, 就是抽象而已
 */
public class App {

    public static void main(String[] args){

        Beverage tea = new Tea();
        tea.drink();

        Beverage coffee = new Coffee();
        coffee.drink();
    }
}

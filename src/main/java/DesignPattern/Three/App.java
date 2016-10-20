package DesignPattern.Three;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 装饰模式, 咖啡,实例如java的文件操作流
 */
public class App {

    public static void main(String[] args){

        Ibeverage coffee = new Coffee();
        coffee = new SugarDecorator(coffee);
        coffee = new WhipDecorator(coffee);
        coffee = new IceDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println("order:"+ coffee.getDescription());
        System.out.println("cost money:" + coffee.cost());
    }
}

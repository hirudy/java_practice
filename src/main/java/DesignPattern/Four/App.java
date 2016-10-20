package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 工厂模式: 简单工厂模式, 工厂方法, 抽象工厂
 */
public class App {

    public static void main(String[] args){
        // 简单工厂模式
        Animal animal = SimpleAnimalFactory.createAnimal("cat");
        animal.talk();

        // 工厂方法
        Pen pen = new PigPen();
        pen.showSkin("white");
        pen.showSkin("red");

        pen = new DogPen();
        pen.showSkin("white");
        pen.showSkin("red");

        // 抽象工厂
        AbstractAnimalFactory factory = new WhiteAnimalFactory();
        System.out.println(factory.createCat().getName() + "|" + factory.createCat().getSkin());

        factory = new RedAnimalFactory();
        System.out.println(factory.createCat().getName() + "|" + factory.createCat().getSkin());
    }
}

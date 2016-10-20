package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 狗圈
 */
public class DogPen extends Pen {
    @Override
    public Animal createAnimal(String skin) {
        switch (skin){
            case "white": return new Dog();
            case "red": return new RedDog();
        }
        return null;
    }
}

package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 白色动物抽象工厂
 */
public class WhiteAnimalFactory extends AbstractAnimalFactory {
    @Override
    public Animal createDog() {
        return new Dog();
    }

    @Override
    public Animal createCat() {
        return new Cat();
    }

    @Override
    public Animal createPig() {
        return new Pig();
    }
}

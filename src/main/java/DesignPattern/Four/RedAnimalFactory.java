package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 红色动物抽象工厂
 */
public class RedAnimalFactory extends AbstractAnimalFactory {
    @Override
    public Animal createDog() {
        return new RedDog();
    }

    @Override
    public Animal createCat() {
        return new RedCat();
    }

    @Override
    public Animal createPig() {
        return new RedPig();
    }
}

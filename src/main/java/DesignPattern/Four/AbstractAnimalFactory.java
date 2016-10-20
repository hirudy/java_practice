package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 抽象工厂基类
 */
public abstract class AbstractAnimalFactory {
    public abstract Animal createDog();

    public abstract Animal createCat();

    public abstract Animal createPig();
}

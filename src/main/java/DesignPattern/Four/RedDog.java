package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 红狗
 */
public class RedDog extends Animal {
    @Override
    public void talk() {
        System.out.println("汪汪叫");
    }

    @Override
    public String getName() {
        return "红狗";
    }

    @Override
    public String getSkin() {
        return "红色";
    }
}

package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 狗
 */
public class Dog extends Animal {
    @Override
    public void talk() {
        System.out.println("汪汪叫");
    }

    @Override
    public String getName() {
        return "狗";
    }

    @Override
    public String getSkin() {
        return "白色";
    }
}

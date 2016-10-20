package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 猪
 */
public class Pig extends Animal {
    @Override
    public void talk() {
        System.out.println("猪叫");
    }

    @Override
    public String getName() {
        return "猪";
    }

    @Override
    public String getSkin() {
        return "白色";
    }
}

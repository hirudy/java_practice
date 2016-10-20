package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 红猪
 */
public class RedPig extends Animal {
    @Override
    public void talk() {
        System.out.println("猪叫");
    }

    @Override
    public String getName() {
        return "红猪";
    }

    @Override
    public String getSkin() {
        return "红色";
    }
}

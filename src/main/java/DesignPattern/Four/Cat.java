package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 猫
 */
public class Cat extends Animal {
    @Override
    public void talk() {
        System.out.println("喵喵叫");
    }

    @Override
    public String getName() {
        return "猫";
    }

    @Override
    public String getSkin() {
        return "白色";
    }

}

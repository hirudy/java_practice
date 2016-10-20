package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 红猫
 */
public class RedCat extends Animal {
    @Override
    public void talk() {
        System.out.println("喵喵叫");
    }

    @Override
    public String getName() {
        return "红猫";
    }

    @Override
    public String getSkin() {
        return "红色";
    }
}

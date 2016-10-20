package DesignPattern.One;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 使用翅膀飞行行为
 */
public class FlyWithWingBehaviour implements IFlyBehaviour {

    @Override
    public void fly() {
        System.out.println("使用翅膀飞行");
    }
}

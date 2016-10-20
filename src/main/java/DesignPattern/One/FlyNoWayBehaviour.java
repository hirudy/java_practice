package DesignPattern.One;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 不具有飞行能力行为
 */
public class FlyNoWayBehaviour implements IFlyBehaviour {

    @Override
    public void fly() {
        System.out.println("不具有飞行能力");
    }
}

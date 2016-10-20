package DesignPattern.One;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 所有鸭子的基类
 *
 */
public abstract class Duck {
    protected IFlyBehaviour flyBehaviour;
    protected IQuackBehaviour quackBehaviour;

    public Duck(){
        flyBehaviour = new FlyNoWayBehaviour(); // 默认飞行行为
        quackBehaviour = new QuackNomalBehaviour(); // 默认吠叫行为
    }

    public void performFlyBehaviour(){
        flyBehaviour.fly();
    }

    public void performQuackBehaviour(){
        quackBehaviour.quack();
    }
}

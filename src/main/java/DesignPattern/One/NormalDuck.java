package DesignPattern.One;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 普通的水鸭子,有飞行能力.呱呱叫
 */
public class NormalDuck extends Duck {

    public NormalDuck(){
        super();
        flyBehaviour = new FlyWithWingBehaviour();
    }
}

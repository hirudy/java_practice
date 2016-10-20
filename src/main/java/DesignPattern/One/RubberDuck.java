package DesignPattern.One;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 橡皮鸭,没有飞行能力,吱吱叫
 */
public class RubberDuck extends Duck {
    public RubberDuck(){
        super();
        quackBehaviour = new QuackSqueakBehaviour();
    }
}

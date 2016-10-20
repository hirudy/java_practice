package DesignPattern.One;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 橡皮鸭的叫声-吱吱叫
 */
public class QuackSqueakBehaviour implements IQuackBehaviour {
    @Override
    public void quack() {
        System.out.println("吱吱叫");
    }
}

package DesignPattern.One;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 正常鸭子的叫声-呱呱叫
 */
public class QuackNomalBehaviour implements IQuackBehaviour {

    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}

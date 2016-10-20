package DesignPattern.Two;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 狗-观察者
 */
public class DogObserver implements IObserver {
    @Override
    public void update(Message message) {
        System.out.println("dog message: " + message.getContent());
    }
}

package DesignPattern.Two;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 猫-观察者
 */
public class CatObserver implements IObserver{
    @Override
    public void update(Message message) {
        System.out.println("cat message: " + message.getContent());
    }
}

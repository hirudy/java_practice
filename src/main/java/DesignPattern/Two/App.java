package DesignPattern.Two;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 观察者模式
 */
public class App {
    public static void main(String[] args){
        Topic topic = new Topic();
        topic.notifyAllObserver(Message.getMessage());

        IObserver dogObserver = new DogObserver();
        topic.registerObserver(dogObserver);
        topic.notifyAllObserver(Message.getMessage());

        IObserver catObserver = new CatObserver();
        topic.registerObserver(catObserver);
        topic.notifyAllObserver(Message.getMessage());

        topic.removeObserver(dogObserver);
        topic.notifyAllObserver(Message.getMessage());
    }
}

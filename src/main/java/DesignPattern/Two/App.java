package DesignPattern.Two;

import java.util.Observable;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 观察者模式 ,实例如redis中订阅发布
 */
public class App {
    public static void main(String[] args){
        ITopic topic = new Topic();
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

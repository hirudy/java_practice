package DesignPattern.Two;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 主题
 */
public class Topic implements ITopic {
    private  List<IObserver> observerList;

    public Topic(){
        observerList = new LinkedList<>();
    }

    @Override
    public synchronized void registerObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public synchronized void removeObserver(IObserver observer) {
        if (observerList.indexOf(observer) >= 0){
            observerList.remove(observer);
        }
    }

    @Override
    public synchronized void notifyAllObserver(Message message) {
        for(IObserver observer: observerList){
            observer.update(message);
        }
    }
}

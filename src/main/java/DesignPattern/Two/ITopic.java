package DesignPattern.Two;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 主题需要实现的接口
 */
public interface ITopic {
    public void registerObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifyAllObserver(Message message);
}

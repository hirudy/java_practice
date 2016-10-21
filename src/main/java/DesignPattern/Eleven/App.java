package DesignPattern.Eleven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 代理模式 剥离客户与具体的产品
 */

public class App {

    public static void main(String[] args){
        // 顾客进到
        ProxySell proxy = ProxySell.createProxy();

        // 如果代理商代理的是第一家工厂的, 买第一家的
        proxy.setFactory(new OneFactory());
        proxy.sell();

        // 如果代理商代理的是第二家的,买第二家的.
        proxy.setFactory(new TwoFactory());
        proxy.sell();
    }
}

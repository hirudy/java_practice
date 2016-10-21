package DesignPattern.Eleven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 代理商, 代理商只需要关心卖接口,而不需要关系生产
 */
public class ProxySell implements ISell {

    private Factory factory; // 委托

    private ProxySell(){}

    public static ProxySell createProxy(){
        return new ProxySell();
    }

    public void setFactory(Factory factory){
        this.factory = factory;
    }

    @Override
    public void sell() {
        factory.sell();
    }
}

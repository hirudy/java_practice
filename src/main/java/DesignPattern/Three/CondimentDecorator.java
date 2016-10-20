package DesignPattern.Three;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 调料-基类
 */
public abstract class CondimentDecorator implements Ibeverage {
    protected Ibeverage beverage;

    public CondimentDecorator(Ibeverage beverage){
        this.beverage = beverage;
    }

}

package DesignPattern.Three;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 调料-糖
 */
public class SugarDecorator extends CondimentDecorator {
    public SugarDecorator(Ibeverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + " + "糖";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3;
    }
}

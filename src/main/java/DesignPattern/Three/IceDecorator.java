package DesignPattern.Three;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 调料-冰
 */
public class IceDecorator extends CondimentDecorator {
    public IceDecorator(Ibeverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + " + "冰";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.5;
    }
}

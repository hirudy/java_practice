package DesignPattern.Three;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 调料-奶酪
 */
public class WhipDecorator extends CondimentDecorator {
    public WhipDecorator(Ibeverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + " + "奶酪";
    }

    @Override
    public double cost() {
        return beverage.cost() + 4;
    }
}

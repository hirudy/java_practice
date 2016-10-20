package DesignPattern.Three;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 饮料-咖啡
 */
public class Coffee implements Ibeverage {

    @Override
    public String getDescription() {
        return "咖啡";
    }

    @Override
    public double cost() {
        return 10;
    }
}

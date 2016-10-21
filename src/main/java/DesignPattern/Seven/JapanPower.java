package DesignPattern.Seven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 日本电压 低电压
 */
public class JapanPower implements LowVoltagePower {
    @Override
    public int getLowVoltagePower() {
        return 110;
    }
}

package DesignPattern.Seven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 中国电源,高电压
 */
public class ChinaPower implements HightVoltagePower {
    @Override
    public int getHightVoltagePower() {
        return 220;
    }
}

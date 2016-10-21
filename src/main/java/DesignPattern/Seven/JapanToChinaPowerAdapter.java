package DesignPattern.Seven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 高电压到低电压适配器
 */
public class JapanToChinaPowerAdapter implements HightVoltagePower {
    private LowVoltagePower lowPower;

    private JapanToChinaPowerAdapter(){}

    public static JapanToChinaPowerAdapter createAdapter(){
        return new JapanToChinaPowerAdapter();
    }

    public void setLowPower(LowVoltagePower lowPower){
        this.lowPower = lowPower;
    }

    @Override
    public int getHightVoltagePower() {
        return lowPower.getLowVoltagePower() * 2;
    }
}

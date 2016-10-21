package DesignPattern.Seven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 适配器模式, 如电压适配器
 */
public class App {
    public static void main(String[] args){
        // 在日本买的电器
        JapanPower power = new JapanPower();
        System.out.println(power.getLowVoltagePower());

        // 在中国用,需要买一个日本电压转中国电压的适配器
        JapanToChinaPowerAdapter adapter = JapanToChinaPowerAdapter.createAdapter();

        // 加上适配器
        adapter.setLowPower(power);

        // 就能使用高电压了
        System.out.println(adapter.getHightVoltagePower());
    }
}

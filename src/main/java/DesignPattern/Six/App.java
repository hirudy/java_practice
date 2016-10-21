package DesignPattern.Six;

/**
 * @author: rudy
 * @date: 2016/10/21
 *
 * 命令模式, 实例如遥控板
 */
public class App {

    public static void main(String[] args){
        SimpleControl control = SimpleControl.createControl();
        control.setCommand(new OneCommand());
        control.pressButton();

        control.setCommand(new TwoCommand());
        control.pressButton();
    }
}

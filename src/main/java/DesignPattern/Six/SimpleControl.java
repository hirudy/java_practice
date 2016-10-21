package DesignPattern.Six;

/**
 * @author: rudy
 * @date: 2016/10/21
 *
 * 控制面板
 */
public class SimpleControl {
    Command slot;

    private SimpleControl(){}

    public static SimpleControl createControl(){
        return new SimpleControl();
    }

    public void setCommand(Command command){
        this.slot = command;
    }

    public void pressButton(){
        slot.execute();
    }
}

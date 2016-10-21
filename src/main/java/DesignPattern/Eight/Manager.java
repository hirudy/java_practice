package DesignPattern.Eight;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 管理者,提供对外接口
 */
public class Manager {

    OneThing one = new OneThing();
    TwoThing two = new TwoThing();

    public void start(){
        one.start();
        two.start();
    }

    public void middle(){
        two.middle();
        System.out.println("do something!");
    }

    public void end(){
        one.end();
        two.end();
    }
}

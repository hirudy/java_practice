package DesignPattern.Nine;

/**
 * @author: rudy
 * @date: 2016/10/21
 *
 * 饮料基类,提取公共的drink方法.每种饮料都有制造与加调料过程.过程抽象化,具体实现延迟到子类
 */
public abstract class Beverage {

    public final void drink(){
        make();
        condiment();
    }

    public abstract void make();

    public abstract void condiment();
}

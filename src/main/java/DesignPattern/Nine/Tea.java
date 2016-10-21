package DesignPattern.Nine;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 茶制造过程
 */
public class Tea extends Beverage {
    @Override
    public void make() {
        System.out.println("用水泡茶");
    }

    @Override
    public void condiment() {
        System.out.println("添加茉莉花,喝茶");
    }
}

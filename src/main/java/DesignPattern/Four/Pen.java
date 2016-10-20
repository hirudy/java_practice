package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 动物圈子基类:如猪圈,羊圈等等
 *
 * 工程方法
 */
public abstract class Pen {
    public void showSkin(String skin){
        Animal animal = this.createAnimal(skin);
        System.out.println(animal.getName() + ":" + animal.getSkin());
    }

    public abstract Animal createAnimal(String skin);
}

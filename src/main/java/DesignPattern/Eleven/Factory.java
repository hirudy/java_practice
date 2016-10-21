package DesignPattern.Eleven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 工厂接口
 */

public abstract class Factory implements ISell {

    public Factory(){
        // 模板模式
        product();
    }

    public abstract void product();
}

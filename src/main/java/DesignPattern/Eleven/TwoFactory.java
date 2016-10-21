package DesignPattern.Eleven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 第2家工厂
 */
public class TwoFactory extends Factory {
    private String productName;

    public void product(){
        productName = "第二家工厂的毛巾";
    }

    @Override
    public void sell() {
        System.out.println("卖" + productName);
    }
}

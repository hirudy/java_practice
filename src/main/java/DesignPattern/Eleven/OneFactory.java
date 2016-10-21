package DesignPattern.Eleven;

/**
 * @author: rudy
 * @date: 2016/10/21
 * 第一家工厂
 */
public class OneFactory extends Factory {
    private String productName;

    public void product(){
        productName = "第一家工厂的毛巾";
    }

    @Override
    public void sell() {
        System.out.println("卖" + productName);
    }
}

package DesignPattern.Four;

/**
 * @author: rudy
 * @date: 2016/10/20
 *
 * 猪圈
 */
public class PigPen extends Pen {
    @Override
    public Animal createAnimal(String skin) {
        switch (skin){
            case "white": return new Pig();
            case "red": return new RedPig();
        }
        return null;
    }
}

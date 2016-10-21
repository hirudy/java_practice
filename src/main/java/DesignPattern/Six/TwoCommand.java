package DesignPattern.Six;

/**
 * @author: rudy
 * @date: 2016/10/21
 *
 *
 */

public class TwoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("second command is running!");
    }
}

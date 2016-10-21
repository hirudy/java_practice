package DesignPattern.Six;

/**
 * @author: rudy
 * @date: 2016/10/21
 *
 * 第一个命令
 */
public class OneCommand implements Command {

    @Override
    public void execute() {
        System.out.println("first command is running!");
    }
}

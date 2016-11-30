import org.junit.Assert;
import org.junit.Test;

/**
 * @author: rudy
 * @date: 2016/11/26
 */
public class TimeOutTest {

    @Test(timeout = 2000)
    public void testTimeOut(){
        while (true){
            System.out.println("I'm running!");
            try {
                Thread.sleep(1000 *1);
            } catch (InterruptedException ignore) {
            }
        }

    }

    @Test(expected = ArithmeticException.class)
    public void testException(){
        Assert.assertEquals(3,6/0);
    }
}

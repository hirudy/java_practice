
import NoFuck.DFAMapTreeFilter;
import javafx.util.Pair;
import org.junit.*;
import org.junit.rules.Timeout;

import java.util.List;

/**
 * @author: rudy
 * @date: 2016/11/26
 */

public class AppTest {

    @BeforeClass
    public static void init(){
        System.out.println("before");
    }

    @AfterClass
    public static void destroy(){
        System.out.println("after");
    }

    @Before
    public void beforeTest(){
        System.out.println("before test ");
    }

    @After
    public void afterTest(){
        System.out.println("after test");
    }

    @Ignore
//    @Test(timeout=2000)
    public void testTest() throws InterruptedException {
        while (true){
            System.out.println("I'm running!");
            Thread.sleep(1000);
        }
    }

    @Test
    public void testAssert(){
        System.out.print("test case: testAssert");
        Assert.assertEquals("testAssert", 0, 0);
    }
}

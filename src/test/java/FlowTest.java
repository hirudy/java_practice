import org.junit.*;

/**
 * @author: rudy
 * @date: 2016/11/26
 */
public class FlowTest {

    @BeforeClass
    public static void init(){
        System.out.println("test class before");
    }

    @AfterClass
    public static void destory(){
        System.out.println("test class after");
    }

    @Before
    public void beforeTest(){
        System.out.println("before test");
    }

    @After
    public void afterTest(){
        System.out.println("after test");
    }

    @Test
    public void testAdd(){
        Assert.assertEquals("test add", 3, 1 + 2);
        System.out.println("Test add ok");
    }

    @Test
    public void testSub(){
        Assert.assertEquals("test subtraction", 3, 4 - 1);
        System.out.println("test sub ok");
    }
}

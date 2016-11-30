import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author: rudy
 * @date: 2016/11/26
 */
@RunWith(Parameterized.class)
public class ParamsTest {
    private int expected;
    private int input1;
    private int input2;

    public ParamsTest(int expected, int input1, int input2){
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> params(){
        return Arrays.asList(new Object[][]{
                {3,2,1},
                {4,1,4}
        });
    }

    @Test
    public void testAdd(){
        Assert.assertEquals("add function",this.expected,this.input1 + this.input2);
    }
}

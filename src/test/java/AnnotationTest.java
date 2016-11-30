import Annotation.Description;
import org.junit.Test;

/**
 * @author: rudy
 * @date: 2016/11/27
 */
public class AnnotationTest {

    @Test
    public void testParse() throws ClassNotFoundException {
        Class cls = Class.forName("Annotation.AnnotationApp");
        boolean isExit =  cls.isAnnotationPresent(Description.class);
        if(isExit){
            Description annotation = (Description) cls.getAnnotation(Description.class);
            System.out.println("get annotation:" + annotation.desc());
        }else{
            System.out.println("no annotation!");
        }
    }
}

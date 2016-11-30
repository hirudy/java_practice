package Annotation;

/**
 * @author: rudy
 * @date: 2016/11/27
 */

@Description(desc = "I'm class annotation")
public class AnnotationApp {

    @Description(desc = "I'm method annotation",author = "rudy")
    public String eyeColor(){
        return "red";
    }
}

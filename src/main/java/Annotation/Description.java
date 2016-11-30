package Annotation;

import java.lang.annotation.*;

/**
 * @author: rudy
 * @date: 2016/11/27
 */

//@Target(ElementType.METHOD)
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String desc() default "";
    String author() default "";
    int age() default 18;
}

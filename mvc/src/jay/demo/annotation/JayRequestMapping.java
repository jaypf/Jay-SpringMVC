package jay.demo.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JayRequestMapping {
	//路径JayRequestMapping(value)
    String value() default "";
}

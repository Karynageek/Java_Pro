package gmail.com;

import java.lang.annotation.*;
@Inherited
@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface Test {
        int a();
        int b();
}

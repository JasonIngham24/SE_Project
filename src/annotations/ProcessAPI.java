package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD }) // Allow usage on both classes/interfaces and methods
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessAPI {

}

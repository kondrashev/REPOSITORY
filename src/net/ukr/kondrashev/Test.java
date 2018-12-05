package net.ukr.kondrashev;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    int paramOne();
    int paramTwo();
}

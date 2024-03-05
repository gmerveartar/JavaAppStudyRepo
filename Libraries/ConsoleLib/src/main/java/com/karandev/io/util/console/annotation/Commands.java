package com.karandev.io.util.console.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Commands {
    Command [] value();
}

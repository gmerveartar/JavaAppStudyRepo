package com.karandev.datetime;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Commands {
    Command [] value();
}

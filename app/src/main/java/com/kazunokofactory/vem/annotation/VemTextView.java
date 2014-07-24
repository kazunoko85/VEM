package com.kazunokofactory.vem.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by kazunoko on 2014/07/23.
 */
@Target(ElementType.FIELD)
public @interface VemTextView {
    String value() default "";
}


package com.haozz.dailylearn.dailylearndetail.dailylearn202103.dailylearn_20210313;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author haozhezhe@yunquna.com
 * @date 11:57 PM 3/13/21
 */
@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String desc();

    int sex() default 0;


}

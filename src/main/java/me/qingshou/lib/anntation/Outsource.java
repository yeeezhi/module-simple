package me.yeezhi.lib.anntation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 告诉编译器将带注释的方法编译为本机代码
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Outsource {

}

package com.hczq.verctrl;

import java.lang.annotation.*;

/**
 * @Description 用于版本控制的注解
 * @Author hejinkang
 * @Date 2023/4/13 14:08
 * @Version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface VerCtrl {
    /**
     * 版本控制的参数存放在哪
     */
    String type() default VerCtrlType.HEADER;

    /**
     * 决定被注解的接口处理哪个版本的请求
     */
    String value();

    /**
     * 版本参数的key
     */
    String key() default "version";


    /**
     * 前缀 比如v1.3 前缀就是v
     * @return
     */
    String suffix() default "v";

    /**
     * 版本比较器，比较哪个版本最新
     * @see StringVerComparator
     */
    Class<?> verComparator() default StringVerComparator.class;
}

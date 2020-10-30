package org.javaboy.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: logging-spring-boot-starter
 * @description: 自定义starter，我们这里写了一个监控方法执行时间的starter
 * @author: lipeng.feng
 * @create: 2020-10-30 08:48
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeLog {
}

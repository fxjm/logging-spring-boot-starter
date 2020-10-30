package org.javaboy.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program: logging-spring-boot-starter
 * @description: 自动配置文件
 * @author: lipeng.feng
 * @create: 2020-10-30 08:56
 **/
@Configuration
@Aspect
@EnableAspectJAutoProxy //开启自动代理 AOP使用
@ConditionalOnProperty(prefix = "time.log",name = "enable",havingValue = "true",matchIfMissing = true)    //是否生效跟配置的Properties有关,matchIfMissing 缺省值
public class TimeLogAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(TimeLogAutoConfiguration.class);

    @Around("@annotation(org.javaboy.logging.TimeLog)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String name = proceedingJoinPoint.getSignature().toLongString().split(" ")[2]; //拿到方法的完整签名 public java.long.String org.javaboy.xxx.controller.hello()

        long starTime = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();//执行方法

        long endTime = System.currentTimeMillis();

        logger.info("方法 {} 耗时 {} ms",name,endTime-starTime);
        return proceed;
    }

    //写好以后，在resources中创建一个META-INF文件夹
    //到此已经写好了，然后在maven中打包，并install到本地仓库
    //然后在创建一个项目，去使用这个自定义的starter,看项目logging_starter_test

}

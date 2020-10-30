package org.javaboy.logging;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: logging-spring-boot-starter
 * @description: 配置文件
 * @author: lipeng.feng
 * @create: 2020-10-30 08:55
 **/
@ConfigurationProperties(prefix = "time.log")
public class TimeLogProperties {
    private Boolean enable;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}

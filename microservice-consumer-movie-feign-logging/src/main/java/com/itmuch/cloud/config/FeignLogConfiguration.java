package com.itmuch.cloud.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignLogConfiguration {
  @Bean
  Logger.Level feignLoggerLevel() {
    /**
     * NONE 不记录日志
     * BASIC  仅记录请求方法URL，相应状态码以及执行时间
     * HEADERS  记录BASIC基础上，记录请求和相应的header
     * FULL  记录请求和响应的header body 和元数据
     * **/
    return Logger.Level.FULL;
  }
  /**
   * 为指定Feign客户端禁用Hystrix
   * **/
  @Bean
  @Scope("prototype")
  public Feign.Builder feignBuilder(){
    return Feign.builder();
  }
}

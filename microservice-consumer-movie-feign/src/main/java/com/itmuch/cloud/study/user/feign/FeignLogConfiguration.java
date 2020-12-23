package com.itmuch.cloud.study.user.feign;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weiwei10
 */
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
   * 为该设置的Feign设置请求头参数
   * **/
  @Bean
  RequestInterceptor headerInterceptor(){
    return new RequestInterceptor() {
      @Override
      public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type", "application/json");
      }
    };
  }
}

package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.feign.GateDetectionFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;

import java.util.HashMap;

@RestController
public class MovieController {
  @Autowired
  private UserFeignClient userFeignClient;

  @Autowired
  private GateDetectionFeignClient gateDetectionFeignClient;

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    return this.userFeignClient.findById(id);
  }

  @GetMapping("/test")
  public User test() {
    Object A  =  this.gateDetectionFeignClient.query(new HashMap());
    return null;
  }
}

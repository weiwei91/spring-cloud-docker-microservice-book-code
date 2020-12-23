package com.itmuch.cloud.study.user.feign;

import com.itmuch.cloud.study.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@FeignClient(name = "gatedetection",configuration = FeignLogConfiguration.class)
public interface GateDetectionFeignClient {
  @RequestMapping(value = "/gatedetection/v1/gate/gates", method = RequestMethod.POST)
  Object query(HashMap map);
}

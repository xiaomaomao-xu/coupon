package com.hsys.coupon.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController

public class MyProjectc {
 @RequestMapping(value = "/showWhatYouSay", method = RequestMethod.POST)
 public String showWhatYouSay(String param) {
     Map<String, Object> map = new HashMap<>();
     map.put("result", param);
//   throw new NullPointerException();
     return JSONObject.toJSONString(map);
 }
}
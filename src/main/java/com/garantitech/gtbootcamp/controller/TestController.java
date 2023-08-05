package com.garantitech.gtbootcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bahadirmemis
 */
@RestController
public class TestController {

  /**
   * baseAddress: localhost:8080
   * uri, URI: /test
   * URL: localhost:8080/test
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, path = "/test")
  public String test(){
    System.out.println("Test GET");
    return "Test GET";
  }

  @RequestMapping(method = RequestMethod.POST, path = "/test")
  public String test2(){
    System.out.println("Test POST");
    return "Test POST";
  }

  //@RequestMapping(method = RequestMethod.POST, path = "/test")
  //public String test3(){
  //  System.out.println("Test POST2");
  //  return "Test POST2";
  //}

  @GetMapping("test-get-2")
  public String testGet2(){
    System.out.println("Test GET 2");
    return "Test GET 2";
  }

  @PostMapping("test-post-2")
  public String testPost2(){
    System.out.println("Test POST 2");
    return "Test POST 2";
  }
}

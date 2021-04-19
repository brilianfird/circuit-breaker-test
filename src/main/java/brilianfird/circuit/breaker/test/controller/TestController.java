package brilianfird.circuit.breaker.test.controller;

import brilianfird.circuit.breaker.test.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  private final HelloWorld helloWorld;

  @Autowired
  public TestController(HelloWorld helloWorld) {
    this.helloWorld = helloWorld;
  }

  @RequestMapping("/")
  String home() {
    return helloWorld.run();
  }
}

package brilianfird.circuit.breaker.test;

import static com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

  @Autowired
  public HelloWorld() {
  }

  @HystrixCommand(fallbackMethod = "getFallback", commandProperties = {
      @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
//      ,
//      @HystrixProperty(name=CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "5000")
  })
  public String run() {
    System.out.println("run");
    throw new RuntimeException();
//    return "Hello " + name;
  }

  public String getFallback() {
    return "Hello Failure!";
  }
}

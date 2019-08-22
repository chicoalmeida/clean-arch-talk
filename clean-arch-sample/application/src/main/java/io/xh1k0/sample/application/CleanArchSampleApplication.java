package io.xh1k0.sample.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "io.xh1k0.sample")
public class CleanArchSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(CleanArchSampleApplication.class, args);
  }

}

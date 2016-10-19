package edu.rosehulman;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.spring.boot.starter.SpringBootProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the "main" entrypoint into the application.
 * It doesn't do anything interesting; sorry!
 * 
 * @author mhays
 *
 */
@SpringBootApplication
@ProcessApplication
public class WebappExampleProcessApplication extends SpringBootProcessApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebappExampleProcessApplication.class, args);
  }

}


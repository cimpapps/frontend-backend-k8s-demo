package com.orange.frontendworkshop.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class GreetingController {

  @Value("${greeting}")
  private String greet;

  @Value("${backend.url}")
  private String backendUrl;

  private final RestTemplate restTemplate;

  public GreetingController() {
    this.restTemplate = new RestTemplate();
  }

  @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String greet() throws UnknownHostException {
    return getHostGreet() + "\n";
  }

  @GetMapping(value = "/hellobackend", produces = MediaType.TEXT_PLAIN_VALUE)
  public String greetBack() throws UnknownHostException {
    return getHostGreet() + "\n \t" + restTemplate.getForObject(backendUrl, String.class) +"\n";
  }

  private String getHostGreet() throws UnknownHostException {
    return greet + ": " + InetAddress.getLocalHost();
  }
}

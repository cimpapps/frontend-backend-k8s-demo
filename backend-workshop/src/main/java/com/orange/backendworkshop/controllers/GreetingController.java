package com.orange.backendworkshop.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class GreetingController {

  @Value("${greeting}")
  private String greet;

  @GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String greet() throws UnknownHostException {
    return greet + ": " + InetAddress.getLocalHost();
  }
}

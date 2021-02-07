package com.starter.javaspring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class BaseController {

  @GetMapping("/")
  public String index(){
    return "Hello World 2021";
  }

}

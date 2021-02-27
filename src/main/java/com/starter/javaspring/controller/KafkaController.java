package com.starter.javaspring.controller;


import com.starter.javaspring.service.impl.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

  private final KafkaProducerService kafkaProducerService;

  @PostMapping(value = "/publish")
  public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
    this.kafkaProducerService.sendMessage(message);
  }

}

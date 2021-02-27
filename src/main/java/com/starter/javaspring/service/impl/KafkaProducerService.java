package com.starter.javaspring.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {

  private static final String TOPIC = "goi-kafka-topic";
  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    log.info(String.format("#### -> Producing message -> %s", message));
    this.kafkaTemplate.send(TOPIC, message);
  }

}

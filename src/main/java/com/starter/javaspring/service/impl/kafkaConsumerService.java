package com.starter.javaspring.service.impl;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class kafkaConsumerService {

  @KafkaListener(topics = "goi-kafka-topic", groupId = "group_id")
  public void consume(String message) throws IOException {
    log.info(String.format("#### -> Consumed message -> %s", message));
  }

}

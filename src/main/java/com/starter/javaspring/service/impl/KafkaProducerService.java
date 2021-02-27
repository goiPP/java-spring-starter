package com.starter.javaspring.service.impl;

import com.starter.javaspring.model.dto.ItemDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {

  private static final String TOPIC = "goi-kafka-topic";
  private final KafkaTemplate<String, ItemDto> kafkaTemplate;

  private void sendMessage(ItemDto message) {
    log.info(String.format("#### -> Producing message -> %s", message.toString()));
    this.kafkaTemplate.send(TOPIC, message);
  }

  public String publishToKafka(List<ItemDto> itemDtoList) {
    itemDtoList.forEach( itemDto -> sendMessage(itemDto));
    return "Publish Done";
  }

}

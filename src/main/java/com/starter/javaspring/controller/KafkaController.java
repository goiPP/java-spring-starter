package com.starter.javaspring.controller;


import com.starter.javaspring.model.dto.ItemDto;
import com.starter.javaspring.service.impl.KafkaProducerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

  private final KafkaProducerService kafkaProducerService;

  @PostMapping(value = "/publish")
  public String sendMessageToKafkaTopic(@RequestBody List<ItemDto> itemDtoList) {
   return this.kafkaProducerService.publishToKafka(itemDtoList);
  }

}

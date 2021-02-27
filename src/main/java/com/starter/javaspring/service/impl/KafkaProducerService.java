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

//  public void publishSync(ItemDto message) {
//    ListenableFuture<SendResult<String, ItemDto>> future = this.kafkaTemplate.send(TOPIC, message);
//    try {
//      SendResult<String, ItemDto> sendResult = future.get();
//      log.info("Sent message=[" + message + "] with offset=[" + sendResult.getRecordMetadata().offset() + "]");
//    } catch (InterruptedException | ExecutionException ex) {
//      // throw any exception here
//    }
//
//  }

//  public void publishAsync(ItemDto message) {
//    ListenableFuture<SendResult<String, ItemDto>> future = kafkaTemplate.send(TOPIC, message);
//
//    future.addCallback(new ListenableFutureCallback<SendResult<String, ItemDto>>() {
//
//      @Override
//      public void onSuccess(SendResult<String, ItemDto> result) {
//        log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
//      }
//
//      @Override
//      public void onFailure(Throwable ex) {
//        log.error("Unable to send message=[" + message + "] due to : " + ex.getMessage());
//      }
//
//    });
//  }

  public String publishToKafka(List<ItemDto> itemDtoList) {
    itemDtoList.forEach( itemDto -> sendMessage(itemDto));
    return "Publish Done";
  }

}

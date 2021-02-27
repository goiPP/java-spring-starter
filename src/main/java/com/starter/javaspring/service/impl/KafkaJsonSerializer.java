package com.starter.javaspring.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
@RequiredArgsConstructor
public class KafkaJsonSerializer implements Serializer<Object> {

  private final ObjectMapper objectMapper;

  public KafkaJsonSerializer() {
    this.objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

  @Override
  public byte[] serialize(String topic, Object data) {
    byte[] retVal;

    try {
      retVal = objectMapper.writeValueAsBytes(data);
    } catch (Exception ex) {
      throw new SerializationException("Error when serializing Object to Json, " + data.toString(), ex);
    }
    return retVal;
  }

}

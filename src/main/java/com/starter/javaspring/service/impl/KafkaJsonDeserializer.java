package com.starter.javaspring.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starter.javaspring.model.dto.ItemDto;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;

@Slf4j
@RequiredArgsConstructor
public class KafkaJsonDeserializer implements Deserializer {

  private final ObjectMapper objectMapper;

  public KafkaJsonDeserializer() {
    this.objectMapper = new ObjectMapper();
  }

  @Override
  public Object deserialize(String s, byte[] bytes) {
    ItemDto obj = null;
    try {
      obj = objectMapper.readValue(bytes, ItemDto.class);
    } catch (DeserializationException ex) {
      throw new DeserializationException("Error when serializing Object to Json, " + bytes.toString(), bytes, false, ex);
    } catch (JsonParseException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return obj;
  }

}

package com.starter.javaspring.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("kafka.topics")
public class KafkaTopicsConfiguration {

  private String itemEvent;

}

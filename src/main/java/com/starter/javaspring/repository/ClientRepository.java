package com.starter.javaspring.repository;

import com.starter.javaspring.model.dto.ItemDto;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ClientRepository {

  WebClient webClient = WebClient.builder().baseUrl("http://localhost:8083").build();

  public Flux<ItemDto> getAllItems() {
    return webClient.get().uri("/items").retrieve().bodyToFlux(ItemDto.class);
  }

  public Mono<ItemDto> getItemByName(String itemName) {
    return webClient.get().uri("/item?itemName=" + itemName).retrieve().bodyToMono(ItemDto.class);
    // return Mono.just(ItemDto.builder().name("test").amount(0).build());
  }

  public Flux<ItemDto> saveItems(List<ItemDto> items) {
    return webClient
        .post()
        .uri("/save")
        .body(Flux.just(items), ItemDto.class)
        .retrieve()
        .bodyToFlux(ItemDto.class);
  }

}

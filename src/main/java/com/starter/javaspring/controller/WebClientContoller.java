package com.starter.javaspring.controller;

import com.starter.javaspring.model.dto.ItemDto;
import com.starter.javaspring.service.WebClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class WebClientContoller {

  private final WebClientService webClientService;

  @GetMapping("/items")
  public Flux<ItemDto> getItems() {
    return webClientService.getAllItems();
  }

  @GetMapping("/item")
  public ItemDto getItem(String itemName) {
    return webClientService.getAnItem(itemName);
  }

  @PostMapping("/save")
  public List<ItemDto> saveItems(List<ItemDto> itemDtos) {
    return webClientService.saveItems(itemDtos);
  }

}

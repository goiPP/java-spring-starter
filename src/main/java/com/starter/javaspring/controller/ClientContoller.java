package com.starter.javaspring.controller;

import com.starter.javaspring.model.dto.ItemDto;
import com.starter.javaspring.service.ClientService;
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
public class ClientContoller {

  private final ClientService clientService;

  @GetMapping("/items")
  public Flux<ItemDto> getItems() {
    return clientService.getAllItems();
  }

  @GetMapping("/item")
  public ItemDto getItem(String itemName) {
    return clientService.getAnItem(itemName);
  }

  @PostMapping("/save")
  public List<ItemDto> saveItems(List<ItemDto> itemDtos) {
    return clientService.saveItems(itemDtos);
  }

}

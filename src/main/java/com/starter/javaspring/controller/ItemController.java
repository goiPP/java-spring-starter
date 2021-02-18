package com.starter.javaspring.controller;

import com.starter.javaspring.model.dto.ItemDto;
import com.starter.javaspring.service.ItemService;
import java.util.List;
import java.util.concurrent.ExecutionException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ItemController {

  private ItemService itemService;

  @PostMapping("/write")
  public String writeItem(@RequestBody ItemDto item) throws ExecutionException, InterruptedException {
    return itemService.writeItem(item);
  }

  @GetMapping("/read")
  public ItemDto readItem(String itemName) throws ExecutionException, InterruptedException {
  return itemService.readItem(itemName);
  }

  @GetMapping("/item")
  public ItemDto getItem(String itemName) {
  return itemService.getItem(itemName);
  }

  @PostMapping("/save")
  public List<ItemDto> saveItem(@RequestBody List<ItemDto> items) {
    return itemService.saveItem(items);
  }

}

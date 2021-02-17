package com.starter.javaspring.controller;

import com.starter.javaspring.domain.Item;
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
  public String writeItem(@RequestBody Item item) throws ExecutionException, InterruptedException {
    return itemService.writeItem(item);
  }

  @GetMapping("/read")
  public Item readItem(String itemName) throws ExecutionException, InterruptedException {
  return itemService.readItem(itemName);
  }

  @PostMapping("/save")
  public List<Item> saveItem(@RequestBody List<Item> items) {
    return itemService.saveItem(items);
  }

}

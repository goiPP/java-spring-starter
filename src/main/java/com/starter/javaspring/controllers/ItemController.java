package com.starter.javaspring.controllers;

import com.starter.javaspring.domains.Item;
import com.starter.javaspring.services.ItemService;
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

  @PostMapping("/save")
  public String writeItem(@RequestBody Item item) throws ExecutionException, InterruptedException {
    return itemService.writeItem(item);
  }

  @GetMapping("/view")
  public Item readItem(String itemName) throws ExecutionException, InterruptedException {
  return itemService.readItem(itemName);
  }

}

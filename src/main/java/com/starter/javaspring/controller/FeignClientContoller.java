package com.starter.javaspring.controller;

import com.starter.javaspring.model.dto.ItemDto;
import com.starter.javaspring.service.FeignClientService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
@RequiredArgsConstructor
@Slf4j
public class FeignClientContoller {

  private final FeignClientService feignClientService;

  @GetMapping("/items")
  public List<ItemDto> getItems() {
    return feignClientService.findAllItems();
  }

  @GetMapping("/item")
  public ItemDto getItem(String itemName) {
    return feignClientService.findByItemName(itemName);
  }

  @PostMapping("/save")
  public List<ItemDto> saveItems(@RequestBody List<ItemDto> itemDtos) {
    return feignClientService.saveItems(itemDtos);
  }


}

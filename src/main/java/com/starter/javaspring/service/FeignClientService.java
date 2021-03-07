package com.starter.javaspring.service;

import com.starter.javaspring.model.dto.ItemDto;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "feign-client", url = "http://localhost:8083")
public interface FeignClientService {

  @RequestMapping(method = RequestMethod.GET, value = "/item")
  ItemDto findByItemName(@RequestParam("itemName") String itemName);

  @GetMapping("/items")
  List<ItemDto> findAllItems();

  @RequestMapping(method = RequestMethod.POST, value = "/save")
  List<ItemDto> saveItems(@RequestBody List<ItemDto> itemDtos);

}

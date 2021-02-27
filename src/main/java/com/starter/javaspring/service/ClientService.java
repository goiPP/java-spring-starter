package com.starter.javaspring.service;

import com.starter.javaspring.model.dto.ItemDto;
import java.util.List;
import reactor.core.publisher.Flux;

public interface ClientService {

  Flux<ItemDto> getAllItems();

  ItemDto getAnItem(String itemName);

  List<ItemDto> saveItems(List<ItemDto> itemDtos);

}

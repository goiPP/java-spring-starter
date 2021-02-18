package com.starter.javaspring.service;

import com.starter.javaspring.model.dto.ItemDto;
import java.util.List;

public interface ClientService {

  List<ItemDto> getAllItems();

  ItemDto getAnItem(String itemName);

  List<ItemDto> saveItems(List<ItemDto> itemDtos);

}

package com.starter.javaspring.service;

import com.starter.javaspring.model.dto.ItemDto;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ItemService {

  String writeItem(ItemDto item) throws ExecutionException, InterruptedException;

  ItemDto readItem(String itemName) throws ExecutionException, InterruptedException;

  ItemDto getItem(String itemName);

  List<ItemDto> getItems();

  List<ItemDto> saveItem(List<ItemDto> items);

}

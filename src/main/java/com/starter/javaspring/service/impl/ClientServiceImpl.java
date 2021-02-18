package com.starter.javaspring.service.impl;

import com.starter.javaspring.model.dto.ItemDto;
import com.starter.javaspring.service.ClientService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  @Override
  public List<ItemDto> getAllItems() {
    return null;
  }

  @Override
  public ItemDto getAnItem(String itemName) {
    return null;
  }

  @Override
  public List<ItemDto> saveItems(List<ItemDto> itemDtos) {
    return null;
  }
}

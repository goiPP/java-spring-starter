package com.starter.javaspring.service.impl;

import com.starter.javaspring.model.dto.ItemDto;
import com.starter.javaspring.repository.WebClientRepository;
import com.starter.javaspring.service.WebClientService;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebWebClientServiceImpl implements WebClientService {

  private final WebClientRepository webClientRepository;

  @Override
  public Flux<ItemDto> getAllItems() {
    return webClientRepository.getAllItems();
  }

//  @Override
//  public List<ItemDto> getAllItems() {
//    List<ItemDto> items = Arrays.asList();
//    clientRepository.getAllItems().subscribe(items::add);
//    return items;
//  }

  @Override
  public ItemDto getAnItem(String itemName) {
    return webClientRepository.getItemByName(itemName).block();
  }

  @Override
  public List<ItemDto> saveItems(List<ItemDto> itemDtos) {
    List<ItemDto> itemDtoList = Arrays.asList();
    webClientRepository.saveItems(itemDtos).map(WebWebClientServiceImpl::changeItemName).subscribe(itemDtoList::add);
    return itemDtoList;
  }


  private static ItemDto changeItemName(ItemDto itemDto) {
    itemDto.setName(itemDto.getName() + " (saved)");
    return itemDto;
  }
}

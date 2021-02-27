package com.starter.javaspring.service.impl;

import com.starter.javaspring.model.dto.ItemDto;
import com.starter.javaspring.repository.ClientRepository;
import com.starter.javaspring.service.ClientService;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  @Override
  public Flux<ItemDto> getAllItems() {
    return clientRepository.getAllItems();
  }

//  @Override
//  public List<ItemDto> getAllItems() {
//    List<ItemDto> items = Arrays.asList();
//    clientRepository.getAllItems().subscribe(items::add);
//    return items;
//  }

  @Override
  public ItemDto getAnItem(String itemName) {
    return clientRepository.getItemByName(itemName).block();
  }

  @Override
  public List<ItemDto> saveItems(List<ItemDto> itemDtos) {
    List<ItemDto> itemDtoList = Arrays.asList();
    clientRepository.saveItems(itemDtos).map(ClientServiceImpl::changeItemName).subscribe(itemDtoList::add);
    return itemDtoList;
  }


  private static ItemDto changeItemName(ItemDto itemDto) {
    itemDto.setName(itemDto.getName() + " (saved)");
    return itemDto;
  }
}

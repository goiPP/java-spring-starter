package com.starter.javaspring.model.mapper;

import com.starter.javaspring.model.domain.Item;
import com.starter.javaspring.model.dto.ItemDto;
import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

@UtilityClass
public class DomainModelMapper {
  private static final ModelMapper modelMapper = new ModelMapper();

  public static Item itemDtoToItem(ItemDto itemDto) {
    return modelMapper.map(itemDto, Item.class);
  }

  public static ItemDto itemToItemDto(Item item) {
    return modelMapper.map(item, ItemDto.class);
  }
}

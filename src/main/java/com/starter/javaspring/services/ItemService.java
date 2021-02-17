package com.starter.javaspring.services;

import com.starter.javaspring.domain.Item;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ItemService {

  String writeItem(Item item) throws ExecutionException, InterruptedException;

  Item readItem(String itemName) throws ExecutionException, InterruptedException;

  List<Item> saveItem(List<Item> items);

}

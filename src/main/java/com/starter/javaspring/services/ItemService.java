package com.starter.javaspring.services;

import com.starter.javaspring.domains.Item;
import java.util.concurrent.ExecutionException;

public interface ItemService {

  String writeItem(Item item) throws ExecutionException, InterruptedException;

  Item readItem(String itemName) throws ExecutionException, InterruptedException;

}

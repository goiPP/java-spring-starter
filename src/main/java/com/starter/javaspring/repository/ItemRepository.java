package com.starter.javaspring.repository;

import com.starter.javaspring.model.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {

  Item findItemByName(String itemName);

}

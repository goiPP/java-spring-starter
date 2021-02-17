package com.starter.javaspring.services.impl;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.starter.javaspring.domain.Item;
import com.starter.javaspring.repository.ItemRepository;
import com.starter.javaspring.services.ItemService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private static final String COL_NAME = "shelf";
  private final ItemRepository itemRepository;
  private Firestore db;

  @Override
  public String writeItem(Item item) throws ExecutionException, InterruptedException {
    db = FirestoreClient.getFirestore();
    DocumentReference docRef = db.collection(COL_NAME).document();
    Map<String, Object> data = new HashMap<>();
    data.put("name", item.getName());
    data.put("amount", item.getAmount());

    ApiFuture<WriteResult> result = docRef.set(data);

    return ("Update time : " + result.get().getUpdateTime());
  }

  @Override
  public Item readItem(String itemName) throws ExecutionException, InterruptedException {
    db = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> query = db.collection(COL_NAME).get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

    List<QueryDocumentSnapshot> filterQueryDocumentSnapshotList = documents.stream()
        .filter(document -> document.getString("name").equalsIgnoreCase(itemName)).collect(
            Collectors.toList());
    if (!filterQueryDocumentSnapshotList.isEmpty()) {
      return filterQueryDocumentSnapshotList.get(0).toObject(Item.class);
    } else {
      return null;
    }
  }

  @Override
  public List<Item> saveItem(List<Item> items) {
    return itemRepository.saveAll(items);
  }
}

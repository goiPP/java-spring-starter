package com.starter.javaspring.service.impl;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class FirebaseService {

  @PostConstruct
  public void intialize() {
    try {
      FileInputStream serviceAccount =
          new FileInputStream("/Users/ppudpad/Desktop/Goi/java-spring-starter/az-pp-b98dd-firebase-adminsdk-mbrhe-20cd01b91f.json");
      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .setDatabaseUrl("https://az-pp-b98dd-default-rtdb.firebaseio.com")
          .build();

      FirebaseApp.initializeApp(options);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

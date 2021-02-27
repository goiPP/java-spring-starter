# java-spring-starter

Swagger 3.0
- http://localhost:8080/swagger-ui/index.html

Lombok
- Constructor injection: @RequiredArgsConstructor will create
constructor with dependency that need to be injected. State that the field
that is declared as 'final' will be accounted as injected dependency. 
https://www.baeldung.com/spring-injection-lombok


Firebase
- Firestore: https://firebase.google.com/docs/firestore/quickstart?authuser=0#java_1
Firebase:
 Is a Backend-as-a-Service (BaaS) base from Google cloud platform, that provide you server + API + database

1. Authentication
- Support oauth2, built-in email authentication
2. Real-time database
- Store and sync database realtime: any data update, Firebase will instantly send update data to all connected clients 
- Allow user to connect to database to sync + get data via web socket (much faster than API). 
- 1 web socket connection will open so that user don’t have to make web socket call everytimes
3. Cloud Firestore
- Let user store data in the cloud with powerful query and fetching
- Work nearly real-time, or user can manual trigger syncing with database
4. Storage
- User can save anything from client to google cloud storage
- User can use storage-api to interact with it
5. Hosting
- Provide easy-to-use hosting service. Serve all global CDN with HTTP (2).
- It utilize Superstatic, that in local you can run Superstatic as BrowserSync
6. Function
- Write a logic in firebase logic, it will be triggered and doing what we define (put logic in here instead of in application
7. Machine Learning



Kafka
- Apache Kafka: https://www.cloudkarafka.com/blog/2016-11-30-part1-kafka-for-beginners-what-is-apache-kafka.html#:~:text=Apache%20Kafka%20is%20a%20publish,processes%2C%20applications%2C%20and%20servers.&text=Another%20application%20may%20connect%20to,retention%20period%20has%20passed%20by.
- Kafka Zookeeper: https://www.cloudkarafka.com/blog/2018-07-04-cloudkarafka_what_is_zookeeper.html 
- HA with kafka: https://jack-vanlightly.com/blog/2018/9/2/rabbitmq-vs-kafka-part-6-fault-tolerance-and-high-availability-with-kafka
- tutorial: https://www.confluent.io/blog/apache-kafka-spring-boot-application/
- There are so many ways to handle serialization (send) and Deserialization (listen)
    1) Use provided Serializer for producer: value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
    2) Consumer consumes string then use ObjectMapper convert to obj. before using
    3) Create Custom Deserializer for T class (https://medium.com/@asce4s/send-and-receive-json-objects-with-kafka-java-client-41bfbb4de108)


### JMS & Microservices

##### Network protocols (http (tcp/ip), socket, JMS, file, database, WebSocket)  tcp = host (ip address) + port

##### JMS (Kafka, Redis, RebitMQ) -> Message Queue

##### Microservice: Java file (JAR, WAR) + config

##### Kafka: topic[1...n] + producer + consumer

##### Spring Cloud (server of configurations)

##### Properties:

1. Discovery -> Service Discovery
2. Fault tolarance -> Circuit Breaker
3. Resilience -> Load Balancing
4. Configuration -> Configuration
5. API management -> API gateway

docker-compose -f .\docker-compose-for-kafka.yml up

##### Patterns:

1. Aggregator
   ![](pattern_1.png)
2. Agent
   ![](pattern_2.png)
3. Chain
   ![](pattern_3.png)
4. Branch
   ![](pattern_4.png)
5. Data sharing
   ![](pattern_5.png)
6. Asynchronous messaging
   ![](pattern_6.png)



# Introduction Kafka
Created by AnhNV Created Date: 18/10/2017

This document provides informaion about the following:

**Reference**:
[What is Kafka?][what-is-kafka]


### what is Kafka
* More than 1/3 of all Fortune 500 companies use Kafka
* Include the top ten travel companies, 7 of top ten banks, 8 of top ten insurance companies, 9 of top ten telecom companies, and much more
* LinkedIn, Microsoft and Netflix process four comma messages a day with Kafka (1,000,000,000,000)

### why Kafka
- Kafka often gets used in real-time streaming data architectures to provide real-time analytics
- Since kafka is a fast, scalable, durable, and fault-tolerant publish-subscribe messaging system
- Kafka is used in case where JMS, RabbitMQ, and AMQP may not even be considered due to volume and responsiveness
- Kafka has higher throughput, reliability and replication characteristics which make it possible for things like tracking service calls or track IOT sensor data

### Kafka use cases
Kafka gets used for stream processing, website activity tracking, metrics collection and monitoring, log aggregation, real-time analytics, CEP, ingesting data into Spark, ingesting data into Hadoop, CQRS, replay messages, error recovery (microservices)

### Who uses Kafka
- Linkedln use Kafka to track activity data and operational metrics
- Twitter uses it as part of Storm to provide a stream processing infrastructure
- Other companies get used like Spotify, Uber, Tumbler, Goldman Sachs, Paypal, Box, Cisco, CloudFlare, NetFlix, and much more

### Why is Kafka so popular
- It has operational simplicity
- It is excellent performance
- It has robust replication
- It provides preserved ordering at shard level (Kafka Topic Partition)
- The most important reason Kafka is popular is Kafka’s exceptional performance

### Kafka Streaming Architecture Diagram
![](https://user-images.githubusercontent.com/14268190/31706889-b4c3701a-b414-11e7-87d8-95cb52caab01.png)

### Kafka is Polygot
- Kafka communication from clients and servers uses a wire protocol over **TCP** that is versioned and documented
- Can use more languages: C#, java, C, Python, Ruby,…
- Kafka ecosystem also providers REST proxy allows easy integration via HTTP and JSON


[what-is-kafka]: http://cloudurable.com/blog/what-is-kafka/index.html
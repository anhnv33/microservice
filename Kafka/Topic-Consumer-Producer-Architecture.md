# Introduction Kafka
Created by AnhNV Created Date: 18/10/2017

This document provides informaion about the following:

- Kafka Topic Architecture - Replication, Failover and Parallel processing

**Reference**:

[Kafka Topic Architecture][kafka-topic-architecture]

[Kafka Consumer Architecture][kafka-consumer-architecture]

## 1. Kafka Topics, Logs, Partitions

Kafka stores topics in logs. A topic log is broken up into partitions. Kafka spreads log's partition across multiple servers or disks. Think of a topic as a category, stream name or feed
Topics are inderently published and subscribe style messaging. A Topic can have zero or many subscribers called consumer groups. Topics are broken up into partitions for speed, scalability and size.

## 2. Kafka Topic Partitions



[kafka-topic-architecture]: http://cloudurable.com/blog/kafka-architecture-topics/index.html 
[kafka-consumer-architecture]: 

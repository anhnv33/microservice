# Topic Architecture
Created by AnhNV Created Date: 18/10/2017

This document provides informaion about the following:

- Kafka Topic Architecture - Replication, Failover and Parallel processing

**Reference**:

[Kafka Topic Architecture][kafka-topic-architecture]

## 1. Kafka Topics, Logs, Partitions

Kafka stores topics in logs. A topic log is broken up into partitions. Kafka spreads log's partition across multiple servers or disks. Think of a topic as a category, stream name or feed
Topics are inderently published and subscribe style messaging. A Topic can have zero or many subscribers called consumer groups. Topics are broken up into partitions for speed, scalability and size.

## 2. Kafka Topic Partitions

Kafka breaks topic logs up into partitions. A record is stored on a partition usually by record key if the key is present and round-robin if the key is missing (default behavior). The record key, by default, detemines which partition a producer sends the record.
Kafka uses partitions to scale a topics across many servers for producer writes. Also, Kafka also uses partitions to factilitate parallel consumers. Consumers consume records in parallel up to the number of partitions.

## 3. Kafka Topic Partition Replication

Kafka can replicate partitions across a configurable number of Kafka servers which is used for fault tolerance. Each partition has a leader server and zero or more follower servers. Leaders handle all read and write requests for a partition.
Followers replicate leaders and take over if the leader dies. Kafka uses also uses partitions for parallel consumer handling within a group. Kafka distributes topic log partitions over servers in the Kafka cluster. Each server handles its share of data and requests by sharing partition leadership.

## 4. Kafka Topic Architecture in Review

**What is an ISR?**
An ISR is an in-sync. If a leader fails, an ISR is picked to be a new leader.

**how does Kafka scale consumers?**
Kafka scales consumers by partition such that each consumer gets it share of partitions. A consumer can have more than one partition, but a partition can only be used by one consumer in a consumer group at a time. If you only have one partition, then you can only have one consumer.

[kafka-topic-architecture]: http://cloudurable.com/blog/kafka-architecture-topics/index.html 

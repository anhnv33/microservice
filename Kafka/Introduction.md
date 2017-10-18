# Introduction Kafka
Created by AnhNV Created Date: 18/10/2017

This document provides informaion about the following:

**Reference**:
[What is Kafka?][what-is-kafka]

## 1. What is Kafka?
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

## 2. Kafka Architecture
> Kafka consists of Records, Topics, Consumers, Producers, Brokers, Logs, Partitions, and Clusters. Records can have key (optional), value and timestamp
Kafka Topic is a stream of records ("/orders", "/user-signups"). Topic is as a feed name. A Topic has a Log which is the topic's storage on disk. A Topic Log is broken up into partitions and segments.
The Kafka Producer API is used to produce streams of data records.
The Kafka Consumer API is used to comsume a stream of records from Kafka.
A Broker is a Kafka server that runs in a Kafka Cluster. Kafka Brokers form a cluster.
Kafka Cluster consists of many Kafka Brokers on many server

**Architecture: Topics, Producers and Consumers**
![](https://user-images.githubusercontent.com/14268190/31708153-666cf568-b418-11e7-9442-d279939a0d27.png)
>Kafka use **ZooKeeper** to manage the cluster. ZooKeeper is used to coordinate the broker/cluster topology. Zookeeper is a consistent file system for configuration information.

**Core Kafka**
![](https://user-images.githubusercontent.com/14268190/31711178-8932437e-b421-11e7-8db2-f1668103d602.png)

**Kafka needs Zookeeper**

_Kafka uses Zookeeper to do leadership election of Kafka Broker and Topic Partition pairs_

_Kafka uses Zookeeper to manage service discovery for Kafka Brokers that form the cluster_.

_Zookeeper sends changes of the topology to Kafka, so each node in cluster knows when a new broker joined, a Broker died, a topic was removed or a topic was added, etc._

_Zookeeper provides an in-sync view of Kafka Cluster configuration._

**Kafka Producer, Consumer, Topic details**

- Kafka producers write to Topics, Kafka consumers read from Topics
- A Topic is associated with a log which is data structure on disk
- Kafka appends records from producer to the end of topic log
- Topic log consists of many partitions that are spread over multiple files which can be spread on multiple Kafka cluster nodes
- Consumers read from Kafka topics at their cadence and can pick where they are (offset) in the topic log
- Each consumer group tracks offset from where they left off reading
- Kafka distributes topic log partitions on different nodes in a cluster for high performance with horizontal scalability
- Topic log partitions are Kafka way to shard reads and writes to the topic log
- Partitions are needed to have multiple consumers in a consumer group work at the same time
- Kafka replicates partitions to many nodes to provide failover.

![](http://cloudurable.com/images/kafka-architecture-topic-partition-consumer-group-offset-producers.png)

[what-is-kafka]: http://cloudurable.com/blog/what-is-kafka/index.html
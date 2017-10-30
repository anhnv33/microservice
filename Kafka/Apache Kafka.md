# Apache Kafka
Created by AnhNV Created Date: 19/10/2017

This document provides informaion about the following:

- Introduction of Kafka

**Reference**:


## 1. Introduction

A few concepts:
- Kafka is run as a cluster on one or more servers
- The Kafka cluster stores streams of records in categories called topics
- Each record consists of a key, a value, and a timestamp

Kafka has four core APIs:
- The Producer API allows an application to publish a stream of records to one or more Kafka topics
- The Consumer API allows an application to subscribe to one or more topics and process the stream of records produced to them
- The Streams API allows an application to act as a stream processor, consuming an input stream from one or more topics and producing an output stream to one or more output topics, effectively transforming the input streams to output streams
- The Connector API allows building and running reusable producers or consumers that connect Kafka topics to existing applications or data systems. For example, a connector to a relational database might capture every change to a table.

**Topics and Logs**
A topic is a category or feed name to which records are published. Topics in Kafka are always multi-subscriber; that is, a topic can have zero, one, or many consumers that subscribe to the data written to it

For each topic, the Kafka cluster maintains a partitioned log that looks like this:
![image](https://user-images.githubusercontent.com/14268190/31761248-7966a410-b4e1-11e7-931b-6760b7163139.png)

The records in the partitions are each assigned a sequential id number called the offset that uniquely identifies each record within the partition.

The Kafka cluster retains all published records—whether or not they have been consumed—using a configurable retention period. For example, if the retention policy is set to two days, then for the two days after a record is published, it is available for consumption, after which it will be discarded to free up space. Kafka's performance is effectively constant with respect to data size so storing data for a long time is not a problem.

The consumer can control the offset in metadata retained. The position (offset) can change by consumer. For example a consumer can reset to an older offset to reprocess data from the past or skip ahead to the most recent record and start consuming from "now".

The partitions in the log serve several purposes. 
- **First, they allow the log to scale beyond a size that will fit on a single server.** Each individual partition must fit on the servers that host it, but a topic may have many partitions so it can handle an arbitrary amount of data
- Second they act as the unit of parallelism—more on that in a bit.

**Distribution**

The partitions of the log are distributed over the servers in the Kafka cluster with each server handling data and requests for a share of the partitions. Each partition is replicated across a configurable number of servers for fault tolerance.

Each partition has one server which acts as the "leader" and zero or more servers which act as "followers". The leader handles all read and write requests for the partition while the followers passively replicate the leader. If the leader fail, one of the followers will automatically become the new leader.

**Producers**

Producers publish data to the topics of their choice. The producer is responsible for choosing which record to assign to which partition within the topic.

**Consumers**

Logical name for 1 or more consumers.

Message consumption is load balanced across all consumers in a group.

**Delivery guarantees**

    Producer
        - Async (No guarantee)
        - Committed to Leader
        - Committed to Leader and Quorum

    Consumer
        - At-least-once (default)
        - At-most-once
        - Effectively-once
        - Exactly Once (Maybe)
    
**Cool feature**    

- Log compaction
- Disk not Heap
- Pagecache to Socket
- Balanced Partitions & Leaders
- Producer & Consumer Quotas
- Heroku Kafka

**Basics Connections**

![image](https://user-images.githubusercontent.com/14268190/31810791-30e33070-b5a7-11e7-8a72-91bf2260853f.png)

**Kafka for Stream Processing**

In Kafka a stream processor is anything that takes continual streams of data from input topics, performs some processing on this input, and produces continual streams of data to output topics. Kafka provides a fully integrated [Streams API](https://kafka.apache.org/documentation/streams/)

**A.Kafka Producer Send, Acks and Buffers**

- Kafka Producer has a __send()__ method which is asynchonous.
- When calling the send method adds the record to the output buffer and return right away
- The buffer is used to batch records for efficient IO and compression (__buffer.memory__)
- The __"all"__ acks setting ensures full commit of record to all replicas and is most durable and least fast setting
- The Kafka Producer can automatically retry failed requests
- The Producer has buffers of unsent records per topic partition (sized at __batch.size__)

**B. Kafka Producer: Buffering and batching**

- The buffers are sent as fast as broker can keep up (limited by in-flight __max.in.flight.requests.per.connection__)
- To reduce requests count and increase throughput, set __linger.ms > 0__

**C. Producer Acks**

- The ack setting is set to "all" (-1), "none" (0), or "leader" (1)

**Acks 0 (None)**

- The acks=0 is none meaning the Producer does not wait for any ack from Kafka broker at all

**Acks 1 (Leader)**

- The means that the Kafka broker acknowledges that the partition leader wrote the record to its local log but responds without the partition followers confirming the write

**Acks -1 (All)**

- The acks=all or acks=-1 is all acknowledgment which means the leader gets write confirmation from the full set of ISRs before sending an ack back to the producer.
- This guarantees that a record is not lost as long as one ISR remains alive
- This ack=all setting is the strongest available guarantee that Kafka provides for durability
- This setting is even stronger with broker setting __min.insync.replicas__ which specifies the minimum number of ISRs that must acknowledge a write.

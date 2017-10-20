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





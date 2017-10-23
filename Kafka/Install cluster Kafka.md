# Apache Kafka
Created by AnhNV Created Date: 23/10/2017

This document provides informaion about the following:

- Setup Kafka fully distributed multi-broker cluster of Apache Kafka

**Reference**:

- [Setup Kafka fully distributed multi-broker on multiple machine][kafka-multiple-setup]

**Pre-required:**

- JDK8 with JAVA_HOME pointing to it
- 2 physical machine with CentOS operation `(192.168.9.61, 192.168.9.63)`

**1. Apache Zookeeper - Cluster setup**

- [ ] Download a stable version of Zookeeper: `wget http://mirrors.advancedhosters.com/apache/zookeeper/zookeeper-3.4.6/zookeeper-3.4.6.tar.gz`
- [ ] Unzip file .gz by command: `tar xzvf zookeeper-3.4.6.tar.gz`
- [ ] Now create and configure a .cfg file in conf folder:
    - `cd zookeeper-3.4.6/conf/`
    - `cp zoo_sample.cfg zoo.cfg`
    - `vi zoo.cfg`
    - Now change dataDir to some permanant location, '/opt/Kafka/ZooKeeper' and add following cluster related configuration to the end of file:
    
        `server.1=0.0.0.0 :2888:3888`

        `server.2=192.168.9.63:2888:3888`

    - Create file myid in each node's data directory `(/opt/Kafka/ZooKeeper/myid)` and put numbers 1,2:
- [ ] Start ZooKeeper in all nodes one by one, using following command: `bin/zkServer.sh start conf/zoo.cfg`
- [ ] Check log file: `tail -f zookeeper.out`

**2. Apache Kafka - Cluster setup**

- [ ] Download and unzip Kafka package in all machines:
    - `cd /opt/wget http://mirror.fibergrid.in/apache/kafka/0.10.0.1/kafka_2.11-0.10.0.1.tgz`
    -  `tar -zxvf kafka_2.11-0.10.0.1.tgz`

- [ ] Configure `server.properties` file in all machines:
    - `cd kafka_2.11-0.10.0.1/config/`
    - `vi server.properties`
    - Change value of broker.id and zookeeper.connect:
        - `broker.id=1 (2 in other machines)`
        - `zookeeper.connect=192.168.9.61:2181,192.168.9.63:2181`
- [ ] Start Kafka on each machine one by one:
    - `bin/kafka-server-start.sh config/server.properties`

[kafka-multiple-setup]:(http://www.techburps.com/misc/multi-broker-apache-kafka-cluster-setup/64)

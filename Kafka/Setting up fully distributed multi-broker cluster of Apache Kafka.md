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
        # The number of milliseconds of each tick
        tickTime=2000
        # The number of ticks that the initial 
        # synchronization phase can take
        initLimit=10
        # The number of ticks that can pass between
        # sending a request and getting an acknowledgement
        syncLimit=5
        # the directory where the snapshot is stored.
        # do not use /tmp for storage, /tmp here is just 
        # example sakes.
        dataDir=/tmp/zookeeper
        # the port at which the clients will connect
        clientPort=2181
        # the maximum number of client connections.
        # increase this if you need to handle more clients
        #maxClientCnxns=60
        #
        # Be sure to read the maintenance section of the 
        # administrator guide before turning on autopurge.
        #
        # http://zookeeper.apache.org/doc/current/zookeeperAdmin.html#sc_maintenance
        #
        # The number of snapshots to retain in dataDir
        #autopurge.snapRetainCount=3
        # Purge task interval in hours
        # Set to "0" to disable auto purge feature
        #autopurge.purgeInterval=1
        
    - Now change dataDir to some permanant location, '/opt/Kafka/ZooKeeper' and add following cluster related configuration to the end of file:
        server.1=0.0.0.0 :2888:3888
        server.2=192.168.9.63:2888:3888
    - Create file myid in each node's data directory `(/opt/Kafka/ZooKeeper/myid)` and put numbers 1,2:
- [ ] Start ZooKeeper in all nodes one by one, using following command: `bin/zkServer.sh start conf/zoo.cfg`
- [ ] Check log file: `tail -f zookeeper.out`

[kafka-multiple-setup]:(http://www.techburps.com/misc/multi-broker-apache-kafka-cluster-setup/64)
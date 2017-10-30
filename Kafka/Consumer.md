# Consumer
Created by AnhNV Created Date: 30/10/2017

This document provides informaion about the following:

- Introduction of Kafka Consumer

**Reference**:


## 1. Introduction

A Kafka client that consumes records from a Kafka cluster. The consumer maintains TCP connections to the necessary brokers to fetch data.

**Offsets and Consumer Position**

Kafka maintains a numerical for each record in a partition. That is, a consumer which has position 5 has consumed records with offsets 0 through 4 and will next receive the record with offset 5. 
# Install ELK on CentOS7

Created by AnhNV Created Date: 04/09/2017

This document provides informaion about the following:

- Install Elasticsearch
- Install Kibana
- Install Logstash

**Reference**: [Installation][elk-instal]

### Prerequisites

  - Require root access to CentOS7
  - Install Java8
>if _Java_ doesn't have on CentOS, you can install by run command line:
>```
>    $ yum install java
>```

# Install Elasticsearch
## Step 1: Import the Elasticsearch public GPG key into rpm
    $ sudo rpm --import http://packages.elastic.co/GPG-KEY-elasticsearch

## Step 2: Create new yum repository file for elasticsearch
    $ echo '[elasticsearch-2.x] \
    name=Elasticsearch repository for 2.x packages \
    baseurl=http://packages.elastic.co/elasticsearch/2.x/centos \
    gpgcheck=1 \
    gpgkey=http://packages.elastic.co/GPG-KEY-elasticsearch \
    enabled=1 \
    ' | sudo tee /etc/yum.repos.d/elasticsearch.repo \

## Step 3: Install Elasticsearch
    $ sudo yum -y install elasticsearch

## Step 4: Edit file configuration
    $ sudo vi /etc/elasticsearch/elasticsearch.yml
Find the line that specifies network.host, uncomment it, and replace its value with "localhost" so it looks like this:
    ```
        network.host: localhost
    ```
Save and exit _elasticsearch.yml_.

## Start Elasticsearch
    $ sudo systemctl start elasticsearch
Run bellow command to start Elasticsearch automatically on boot up:
    ```
        $ sudo systemctl enable elasticsearch
    ```    
    
   [elk-instal]: <https://www.digitalocean.com/community/tutorials/how-to-install-elasticsearch-logstash-and-kibana-elk-stack-on-centos-7>
   

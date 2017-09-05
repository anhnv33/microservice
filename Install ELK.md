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

## Step 5: Start Elasticsearch
    $ sudo systemctl start elasticsearch
Run bellow command to start Elasticsearch automatically on boot up:
    ```
        $ sudo systemctl enable elasticsearch
    ```    
    
# Install Kibana

## Step 1: Create and edit a new yum repository file for Kibana
    $ sudo vi /etc/yum.repos.d/kibana.repo
Add the following repository configuration:

| /etc/yum.repos.d/kibana.repo |
| ------ |
| [kibana-4.4] |
| name=Kibana repository for 4.4.x packages |
| baseurl=http://packages.elastic.co/kibana/4.4/centos |
| gpgcheck=1 |
| gpgkey=http://packages.elastic.co/GPG-KEY-elasticsearch |
| enabled=1 |

Save and exit.

## Step 2: Install Kibana
    $ sudo yum -y install kibana
Open the Kibana configuration file for editing:
    ```
        sudo vi /opt/kibana/config/kibana.yml
    ```
    
Find the line that specifies server.host, and replace the IP address ("0.0.0.0" by default) with "localhost":

| kibana.yml excerpt (updated) |
|-------------------|
| server.host: "localhost" |
Save and exit.

Start the Kibana service, and enable it:

```
$ sudo systemctl start kibana
$ sudo chkconfig kibana on
```

# Install Logstash
### Step 1: Create and edit a new Yum repository file for Logstash
    $ sudo vi /etc/yum.repos.d/logstash.repo
Add the following repository configuration:
| /etc/yum.repos.d/logstash.repo |
|-------------------|
| [logstash-2.2] |
| name=logstash repository for 2.2 packages |
| baseurl=http://packages.elasticsearch.org/logstash/2.2/centos |
| gpgcheck=1 |
| gpgkey=http://packages.elasticsearch.org/GPG-KEY-elasticsearch |
| enabled=1 |

Save and exit
### Step 2: Install Logstash
    $ sudo yum -y install logstash


   [elk-instal]: <https://www.digitalocean.com/community/tutorials/how-to-install-elasticsearch-logstash-and-kibana-elk-stack-on-centos-7>
   

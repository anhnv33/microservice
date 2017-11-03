## Container Orchestrators

Nowadays, there are many Container Orchestrators available:

- **Docker Swarm** provided by Docker
- **Kubernetes** provided by Google, but now, it is a part of the Cloud Native Computing Foundation project
- **Mesos Marathon** is one of the frameworks to run containers at scale on Apache Mesos
- **Amazon ECS** provided by AWS
- **Hashicorp Nomad** provided by HashiCorp

## Container Orchestrators can:
- Bring multiple host together and make them part of a cluster
- Schedule containers to run on different hosts
- Help Containers running on one host reach out to containers on other hosts in the cluster
- Bind Containers and storage
- Bind containers of similar type to a higher-level contruct, like services, 
- Keep resource usage in-check
- Allow secure access to applications running inside containers

## What is Kubernetes?
Kubernetes comes from the Greek word κυβερνήτης:, which means helmsman or ship pilot. With this analogy in mind, we can think of Kubernetes as the manager for shipping containers.

Kubernetes is also referred to as k8s, as there are 8 characters between k and s.

Kubernetes is highly inspired by the Google Borg system, which we will explore in this chapter. It is an open source project written in the Go language, and licensed under the Apache License Version 2.0.

Kubernetes was started by Google and, with its v1.0 release in July 2015, Google donated it to the Cloud Native Computing Foundation (CNCF).

## Kubernetes Features I

Kubernetes offers a very rich set of features for container orchestration. Some of its fully supported features are:

- **Automatic binpacking**
    Kubernetes automatically schedules the containers based on resource usage and constraints, without sacrificing the           availability.
- **Self-healing**
    Kubernetes automatically replaces and reschedules the containers from failed nodes. It also kills and restarts the           containers which do not respond to health checks, based on existing rules/policy.
- **Horizontal scaling**
    Kubernetes can automatically scale applications based on resource usage like CPU and memory. In some cases, it also          supports dynamic scaling based on customer metrics.
- **Service discovery and Load balancing**
    Kubernetes groups sets of containers and refers to them via a DNS name. This DNS name is also called a Kubernetes            service. Kubernetes can discover these services automatically, and load-balance requests between containers of a given       service.
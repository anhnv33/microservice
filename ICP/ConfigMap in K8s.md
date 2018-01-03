# ConfigMap in K8s
Created by AnhNV Created Date: 03/01/2017

ConfigMaps allow you to decouple configuration artifacts from image content to keep containerized applications portable. This page provides a series of usage examples demonstrating how to create ConfigMaps and configure Pods using data stored in ConfigMaps.

**Reference**:
- [Configure a Pod to Use a ConfigMap][configmap-k8s]

## 1. Create a ConfigMap
Use the ```kubectl create configmap``` command to create configmaps from directories, files, or literal values:
```code
kubectl create configmap <map-name><data-source>
```
<map-name> : The name will assign to the ConfigMap
<data-source> : Directory, file, literal value

The data source corresponds to a key-value pair in the ConfigMap
- key = the file name or the key provided on the command line
- value = the file contents or the literal value

### Create ConfigMaps from directories
Can use ```kubectl create configmap``` to create a ConfigMap from multiple files in the same directory
```code
kubectl create configmap game-config --from-file=docs/user-guide/configmap/kubectl
```
Verify ConfigMap by command ```kubectl describe configmaps game-config```
The **game.properties** and **ui.properties** files in the docs/user-guide/configmap/kubectl/ directory are represented in the **data** section of the ConfigMap
```code
kubectl get configmaps game-config -o yaml
```
```php
apiVersion: v1
data:
  game.properties: |
    enemies=aliens
    lives=3
    enemies.cheat=true
    enemies.cheat.level=noGoodRotten
    secret.code.passphrase=UUDDLRLRBABAS
    secret.code.allowed=true
    secret.code.lives=30
  ui.properties: |
    color.good=purple
    color.bad=yellow
    allow.textmode=true
    how.nice.to.look=fairlyNice
kind: ConfigMap
metadata:
  creationTimestamp: 2016-02-18T18:52:05Z
  name: game-config
  namespace: default
  resourceVersion: "516"
  selfLink: /api/v1/namespaces/default/configmaps/game-config
  uid: b4952dc3-d670-11e5-8cd0-68f728db1985
```

[configmap-k8s]: <https://kubernetes.io/docs/tasks/configure-pod-container/configure-pod-configmap>
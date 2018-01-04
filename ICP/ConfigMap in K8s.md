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

### Create ConfigMaps from files
```code
kubectl create configmap game-config-2 --from-file=docs/user-guide/configmap/kubectl/game.properties
```
would produce the following ConfigMap:
```php
kubectl describe configmaps game-config-2
Name:           game-config-2
Namespace:      default
Labels:         <none>
Annotations:    <none>

Data
====
game.properties:        158 bytes
```
You can pass in ```--from-file``` argument multiple times to create a ConfigMap from multiple data sources
```code
kubectl create configmap game-config-2 --from-file=docs/user-guide/configmap/kubectl/game.properties --from-file=docs/user-guide/configmap/kubectl/ui.properties
```

### Define the key to use when creating a ConfigMap from a file
You can define a key other than the file name to use in the data section of your ConfigMap when using the ```--from-file``` argument:
```code
kubectl create configmap game-config-3 --from-file=<my-key-name>=<path-to-file>
```

For example:
```code
kubectl create configmap game-config-3 --from-file=game-special-key=docs/user-guide/configmap/kubectl/game.properties
kubectl get configmaps game-config-3 -o yaml
```

```php
apiVersion: v1
data:
  game-special-key: |
    enemies=aliens
    lives=3
    enemies.cheat=true
    enemies.cheat.level=noGoodRotten
    secret.code.passphrase=UUDDLRLRBABAS
    secret.code.allowed=true
    secret.code.lives=30
kind: ConfigMap
metadata:
  creationTimestamp: 2016-02-18T18:54:22Z
  name: game-config-3
  namespace: default
  resourceVersion: "530"
  selfLink: /api/v1/namespaces/default/configmaps/game-config-3
  uid: 05f8da22-d671-11e5-8cd0-68f728db1985
```
### Create ConfigMaps from literal values
You can use ```kubectl create configmap``` with the ```--from-literal``` argument to define a literal value from the command line:
```code
kubectl create configmap special-config --from-literal=special.how=very --from-literal=special.type=charm
kubectl get configmaps special-config -o yaml
```
```code
apiVersion: v1
data:
  special.how: very
  special.type: charm
kind: ConfigMap
metadata:
  creationTimestamp: 2016-02-18T19:14:38Z
  name: special-config
  namespace: default
  resourceVersion: "651"
  selfLink: /api/v1/namespaces/default/configmaps/special-config
  uid: dadce046-d673-11e5-8cd0-68f728db1985
```

### Define Pod environemt variables using ConfigMap data
1. Define an environment variable as a key-value pair in a ConfigMap:
```code
kubectl create configmap special-config --from-literal=special.how=very 
```
2. Assign the special.how value defined in the ConfigMap to the **SPECIAL_LEVEL_KEY** environment variable in the Pod specification
```code
kubectl edit pod dapi-test-pod
```
```code
apiVersion: v1
kind: Pod
metadata:
  name: dapi-test-pod
spec:
  containers:
    - name: test-container
      image: k8s.gcr.io/busybox
      command: [ "/bin/sh", "-c", "env" ]
      env:
        # Define the environment variable
        - name: SPECIAL_LEVEL_KEY
          valueFrom:
            configMapKeyRef:
              # The ConfigMap containing the value you want to assign to SPECIAL_LEVEL_KEY
              name: special-config
              # Specify the key associated with the value
              key: special.how
  restartPolicy: Never
```
3. Save the changes to the Pod specification
    
[configmap-k8s]: <https://kubernetes.io/docs/tasks/configure-pod-container/configure-pod-configmap>
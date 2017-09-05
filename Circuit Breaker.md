# What is the Netflix Hystrix Circuit Breaker?

Created by AnhNV Created Date: 05/09/2017

This document provides informaion about the following:

- Define Netflix Hystrix Circuit Breaker

### Example
Due to some reason the employee-producer exposed service throws an exception. In this case using Hystrix we defined a fallback method. In case of exception in the exposed service the fallback method returned some default value.
![](https://raw.githubusercontent.com/anhnv33/microservice/master/image2.png)
If the exceptions keep on occuring in the firstPage method() then the Hystrix circuit will break and the employee consumer will skip the firtsPage method all together and directly call the fallback method.
The purpose of circuit breaker is to give time to the first page method or other methods that the firstpage method might be calling and is causing the exception to recover. It might happen that on less load the issue causing the exceptions have better chance of recovering

![](https://raw.githubusercontent.com/anhnv33/microservice/master/image1.png)
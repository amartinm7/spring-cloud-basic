https://www.baeldung.com/spring-cloud-bootstrapping

This cloud example has a lot of thicky parts:

# I: setup a git repo to store the configuration files of the servers
Create a folder, init a git repo and add the properties files.

create a git repo in a folder.
in this folder create the next files: 
- discovery.properties
- gateway.properties
...

add all the files al git repo
```bash
git init
git add . 
git commit -a -m "adding properties"
```

setup the path to this folder in the "config" application.properties, for instance:
```bash
spring.cloud.config.server.git.uri = file://Users/your-user/IntellijProjects/xxx-folder-xxx
``` 

# II: setup the config service properly

In the config service project, go to the application.properties:
- first comment the discovery properties
- in the config application, comment the eureka annotation
- and run the config server
- in this way the config runs without looking up for the discovery service
- then run the discovery server
- in order to run the exercise we need to register this config in the discovery service
- so we have to uncomment the commented properties and run another time the config service


# III: run the whole cloud

run: 
- config service without discovery client
- discovery service
- config service with discovery client
- gateway service
- book-service
- ratings-service

```html
http://192.168.1.42:8082
http://192.168.1.42:8080/book-service/books/1
http://192.168.1.42:8080/book-service/books/all
http://192.168.1.42:8080/rating-service/ratings/1
http://192.168.1.42:8080/rating-service/ratings/all
```
important, console discovery service in http://192.168.1.42:8082 

## start.spring.io
for creating every module/projects go to https://start.spring.io

## References and tutorials

https://www.baeldung.com/spring-cloud-bootstrapping
https://www.baeldung.com/spring-cloud-tutorial
https://cloud.spring.io/spring-cloud-config/1.1.x/


![springboot](https://sdtimes.com/wp-content/uploads/2018/03/spring-boot-490x257.png)

# Bookshelf
Bootstrap application for testing a bookshelf

## create a new spring project from the scratch
First of all, you can generate the scaffolding of this project using the INITIALIZR tool: 
https://start.spring.io/

in the dependencies field, write JPA and H2. After that, generate the project.
You can use the scaffolding straightly in intellij.

## reference starting point
https://www.baeldung.com/spring-boot-start

https://www.baeldung.com/spring-cloud-bootstrapping

https://github.com/eugenp/tutorials/tree/master/spring-cloud/spring-cloud-bootstrap

## run springboot app
./gradlew bootRun

## create a new book
curl -d '{"title":"helloworld", "author":"whoknows"}' -H "Content-Type: application/json" -X POST http://localhost:8081/api/books

## get a book
curl -H "Content-Type: application/json" -X GET http://localhost:8081/api/books/1

## run the cloud 
Make sure to run the modules in the following order:
• Run the configuration server port 8081
• Then, run discovery server port 8082
• After that, run gateway server port 8080
• Finally, run resource servers port 808􏰙3, 808􏰚4


## References
https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#spring-webflux
http://cloud.spring.io/spring-cloud-static/Finchley.SR1/single/spring-cloud.html
https://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#csrf-configure

## Spring Webflux
![spring webflux](https://spring.io/img/homepage/diagram-boot-reactor.svg)

## Spring Cloud

![spring cloud](https://spring.io/img/homepage/diagram-distributed-systems.svg)


### Versioning 

Versioning:
- define a REST API contract, let's say v1.
- when the REST API contract is changing then we have to create another version, let's say v2

for instance:
* http://localhost:8080/rest/api/v1/book/{id}
* http://localhost:8080/rest/api/v2/country/language/book/{id}

clue: if the consumer has to adapt the calls then we have to create a new version.


Versioning in AWS:
To sum up: 
* create a Route53 instance, 
* create two cloudfront distributions, each for every version v1 and v2
* create two API Gateways, each for every version v1 and v2
* create two Lambda, each for every version v1 and v2 

The key point is the Route 53. This service routes the calls. So here we have to set up a rule to differenciate the incoming calls.
We can use the URL, we can read the path-parameters to differenciate between the versions.
Let's say if the URL contains the suffix 'v1' then we have to route the call to the cloudfront with this version. 
If the URL contains the suffix 'v2' then we have to route the call to the cloudfront with this version.
That is.

While we are adding more versions we have to create the cloudfront, api gateway and lambda. 
After that, we have to add the rule in the Route 53 to say when call to the new version pointing to the cloudfront CDN.
The old versions can disappear with the time, deprecating them. So we can delete them little by little.











### Versioning 

Versioning:
- define a REST API contract, let's say v1.
- when the REST API contract is changing then we have to create another version, let's say v2

for instance:
* http://localhost:8080/rest/api/v1/book/{id}
* http://localhost:8080/rest/api/v2/country/language/book/{id}

clue: if the consumer has to adapt the calls then we have to create a new version.


Versioning in AWS:
To sum up: 
* create a Route53 instance, 
* create two cloudfront distributions, each for every version v1 and v2
* create two API Gateways, each for every version v1 and v2
* create two Lambda, each for every version v1 and v2 

The key point is the Route 53. This service routes the calls. So here we have to set up a rule to differenciate the incoming calls.
We can use the URL, we can read the path-parameters to differenciate between the versions.
Let's say if the URL contains the suffix 'v1' then we have to route the call to the cloudfront with this version. 
If the URL contains the suffix 'v2' then we have to route the call to the cloudfront with this version.
That is.

While we are adding more versions we have to create the cloudfront, api gateway and lambda. 
After that, we have to add the rule in the Route 53 to say when call to the new version pointing to the cloudfront CDN.
The old versions can disappear with the time, deprecating them. So we can delete them little by little.



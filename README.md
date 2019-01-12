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
http://192.168.1.42:8080/book-service/books/1
http://192.168.1.42:8080/book-service/books/all
http://192.168.1.42:8080/rating-service/ratings/1
http://192.168.1.42:8080/rating-service/ratings/all
```

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



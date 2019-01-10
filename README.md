https://www.baeldung.com/spring-cloud-bootstrapping

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


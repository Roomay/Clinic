## The directory is for the back-end build .

### Docker Config
docker port mapped to 3383 (avoid to be confused with other Docker instance )
```
$ docker run --name clinic -e MYSQL_ROOT_PASSWORD=123456 -p 3383:3306 -d mysql:8.0 
```



### Originality and Reference Declaration

* Our AI engine is based on an open-source BERT model, so the framework of the AI engine refers to ...
* Our frontend design is based on 
* Our backend design is based on an open-source framework Spring Boot. 
  * The skeleton of dependency library configuration defined in the file "pom.xml" was referred to [maven.apache.org](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html#:~:text=Available%20Variables-,What%20is%20a%20POM%3F,default%20values%20for%20most%20projects.). 
  * The skeleton of the Java Web framework was referred to [Spring Boot](https://spring.io/guides/gs/spring-boot/).
* We hereby declare that except the parts mentioned above, all other parts of source code are done by us.


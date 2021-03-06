# Recruiting #

Recruiting, is an Open-sourced Web Application which handles the registration, search, recruitment and any other kind of management in a Consultancy company.

It's been built making use of the lightweight container [Spring Framework](http://spring.io/) and, currently can be backed with two databases: [MongoDB](http://www.mongodb.org/) and [MySQL](http://www.mysql.com/), that is, a classic RDBMS and a NoSQL databases (just to experiment). Which database technology you use, will depend on what spring @Profile you'll use when the container will be started.

## Requirements ##

The technologies required are:

* JDK **1.7_x+**
* [Apache Maven **3.x**](http://maven.apache.org/)
* One database up and running, which could be:
	* MySQL Server running on: **localhost**, listening port: **3306** and a linked database named: **recruiting**.
	* MongoDB running on: **localhost**, listening port: **27017**. **"NOTHING MORE"** since databases, collections and documents are created automatically if them do not exist.

## Compile and Run ##

In order to compile and run application in your local computer it's sufficient to launch these Maven commands:

* `$ mvn clean install`	at the root directory folder level `$ cd recruiting/pom.xml`
* `$ mvn jetty:run-war -Dspring.profiles.active=mysql` if you have MySQL up and running. Or:
* `$ mvn jetty:run-war -Dspring.profiles.active=mongodb` if you have MongoDB up and running. All of this must be done at the recruiting-webapp folder level: `$ cd recruiting/recruiting-webapp/pom.xml`
* After these commands are launched, the application will listen on: [http://localhost:8080/recruiting](http://localhost:8080/recruiting)

As can be seen, the Web server used is [Jetty](http://www.eclipse.org/jetty/). This because in the future it may (potentially) be useful with the aim of introduce the [SPDY](http://en.wikipedia.org/wiki/SPDY) protocol.

License
-------

This software is licensed under the [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
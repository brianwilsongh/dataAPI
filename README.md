This is a Spring Boot web application to demonstrate banking transactions

### Installation

"dataAPI" demo requires Java 1.8 or higher.

To check if Java is installed on your computer, type the following into your command line.

`java -version`

If a version number is not displayed, visit [this page](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and follow the installation instructions for a version of Java 1.8 or higher.


### How to Run

The quickest way to run is with Apache Maven. This app has only been tested on Maven 3.5.0

Installation instructions are [here](https://maven.apache.org/install.html)

Once you have both Maven and Java, simply type the following into your command line:

```sh
mvn spring-boot:run
```

This will spin up the application on localhost:8080

### Using the application

Create data by sending POST requests to the following endpoint:

localhost:8080/analytics?timestamp={millis_since_epoch}&user={user_id}&event={click|impression}

Retrieve data for a particular timestamp by sending GET requetsts to this endpoint:

localhost:8080/analytics?timestamp={millis_since_epoch}

The application uses H2 as its database, data will not persist between instances of the application


### Todos

 - Create unit tests
 - Create integration tests to test functionality of controllers
 - Potentially find a way to make read operations though the GET endpoint faster

License
----
MIT

# springBootMongDB
## This is an exercise project with Spring Boot and MongoDB database.

The repository contains a Java Spring Boot application that uses MongoDB as a database. The main code is located in the ```src/main/java/com/demo2``` directory.

The ```Student``` class in ```src/main/java/com/demo2/model``` represents the data model for the application. It contains fields for the student’s name, email, and phone number.

The ```StudentRepository``` interface in ```src/main/java/com/demo2/repository``` defines the MongoDB repository for performing database operations on student objects. It extends the MongoRepository interface and provides additional methods for querying the database.

The ```StudentController``` class in src/main/java/com/demo2/controller contains the RESTful API controllers for handling HTTP requests. It provides methods for performing CRUD operations on student objects.

The ```Demo2Application``` class in ```src/main/java/com/demo2``` is the entry point for the application and contains the main method.

The ```application.properties``` file in ```src/main/resources``` contains configuration settings for connecting to the MongoDB database.

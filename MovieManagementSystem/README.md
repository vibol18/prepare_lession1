# Movie Management System

A console-based Java application for managing a personal movie catalog. It supports creating, listing, searching, updating, and deleting movies. Data is held in memory and is reset when the application exits.

## Requirements

- JDK 17 or newer
- Maven 3.8 or newer

## Run

From this directory, compile and start the application:

```sh
mvn clean compile
mvn exec:java -Dexec.mainClass="com.movie.Main"
```

Alternatively, run `com.movie.Main` from your IDE after importing the project as a Maven project. To run the tests:

```sh
mvn test
```

## Movie fields

- Title
- Genre (`ACTION`, `COMEDY`, `SCIENCE_FICTION`, etc.)
- Release year
- Rating from 0 to 10
- Status (`WATCHLIST`, `WATCHED`, or `AVAILABLE`)

Search matches movie titles and genre names without regard to capitalization.

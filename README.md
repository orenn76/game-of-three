## Game of Three - RESTful Web Services

#### Goal

The Goal is to implement a game with two independent units – the players –
communicating with each other using an API.

#### Description

When a player starts, it generates a random (whole) number and sends it to the second
player as an approach of starting the game.
The receiving player can now choose between adding one of {­1, 0, 1} to get
to a number that is divisible by 3, divide it by three, and send the resulting whole number to the original sender.
The same rules are applied until one player reaches the number 1 (after the division) and wins.

For each "move", a sufficient output should get generated (mandatory: the added, and the resulting number).
Both players should be able to play automatically without user input. One of the players
should optionally be adjustable by a user

## Requirements

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Gradle-3.3+](https://gradle.org/install/)

## Build and run tests with Gradle

* cd into project-root-folder using the terminal.

* Run this gradle command:
 
``` 
gradle clean build
``` 

## Publish locally with Gradle

* cd into project-root-folder using the terminal.

* Run this gradle command:
 
``` 
gradle clean publish
``` 

## Run with Gradle

* cd into project-root-folder using the terminal.

* Run this gradle command:
 
``` 
gradle bootRun
``` 

## Test the services

Start **player-a** and **player-b** services, and visit one of these URLs:

```
http://localhost:8080/player-a
```

```
http://localhost:8080/player-a?number=168
```

```
http://localhost:8090/player-b
```

```
http://localhost:8090/player-b?number=168
```
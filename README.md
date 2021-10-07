# OpenLogger
[![Maven Central](https://img.shields.io/maven-central/v/io.github.mrslimediamond/OpenLogger.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.mrslimediamond%22%20AND%20a:%22OpenLogger%22)

Basic logging system for Java
## Usage
### For Lazy People
Just copy paste everything in `src/main/java` to your project (including <a href="LICENSE">the license</a>).
### Maven or Gradle
Maven:
```xml
<dependency>
  <groupId>io.github.mrslimediamond</groupId>
  <artifactId>OpenLogger</artifactId>
  <version>1.0.0</version>
</dependency>
```
Gradle (Groovy):
```gradle
implementation 'io.github.mrslimediamond:OpenLogger:1.0.0'
```
Gradle (Kotlin):
```kts
implementation("io.github.mrslimediamond:OpenLogger:1.0.0")
```
### Import and use
```java
import io.github.mrslimediamond.openlogger.OpenLogger;

public class Main {

  public static void main(final String[] args) {
    OpenLogger.info("This is very important info that I must tell you.");
    OpenLogger.warn("Just warning you about something");
    OpenLogger.error("Something went wrong!");
  }

}
```
Alternatively, you can use it like this:
```java
import io.github.mrslimediamond.openlogger.Log;

public class Main {

  static Log c = new Log();

  public static void main(final String[] args) {
    c.info("Stuff");
  }

}
```
To change the format, you can just pass in an argument:
```java
Log log = new Log((level, caller, in) -> level + ": " + in); // LEVEL: message
```
The log level can also be changed, allowing to customize verbosity:
```java
Log log = new Log(LogLevel.valueOf(LogLevel.WARN));
```
This will only show messages that are warnings or less verbose (e.g. errors).

You can also set a package instance:
```java
OpenLogger.setDefaultLog("cool.app", new Logger((level, caller, in) -> "Fish cakes!!!"));
OpenLogger.info("An extremely important message will follow."); // [Main/INFO] Fish cakes!!!
```
![image](https://user-images.githubusercontent.com/43764702/122656419-5ecdea80-d1ae-11eb-8ccb-ab51e5ce9980.png)
## Issues
Report issues on the official [issue tracker](https://github.com/MrSlimeDiamond/OpenLogger/issues)

# OpenLogger
[![Maven Central](https://img.shields.io/maven-central/v/io.github.mrslimediamond/OpenLogger.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.mrslimediamond%22%20AND%20a:%22OpenLogger%22)

Basic logging system for Java
## Usage
Just copy paste the `Log.java` file from `src/main/java/Log.java` somewhere in your path
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
import io.github.mrslimediamond.openlogger.Log;

public class Main {
  public static void main(final String[] args) {
    Log.info("This is very important info that I must tell you.");
    Log.warn("Just warning you about something");
    Log.error("Something went wrong!");
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
![image](https://user-images.githubusercontent.com/43764702/122656419-5ecdea80-d1ae-11eb-8ccb-ab51e5ce9980.png)
## Issues
Report issues on the official [issue tracker](https://github.com/MrSlimeDiamond/OpenLogger/issues)

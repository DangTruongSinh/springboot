- Log4j 2 provides a significant improvement in performance compared to its predecessor. It contains asynchronous loggers 
and supports multiple APIs including SLF4J, commons logging, and java.util.loggging.
- All project spring boot using Logback by default.For using log4j2, you need to exclude spring-boot-starter-logging 
and add spring-boot-starter-log4j2 dependency inside pom.xml
- Spring Boot automatically configures Log4j if it finds a file named log4j2.xml 
or log4j2.json or log4j2.yaml in the classpath.
- In the file log4j2.yaml, the date/time pattern of the file is {yyy-MM-dd}, where the most specific time unit is dd (date). 
Therefore the TimeBasedTriggeringPolicy roll files over based on date. If the date/time pattern was yyy-MM-dd-HH, 
the rollover would occur based on hour.
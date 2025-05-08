
# HTTP Log Analyzer

This java program parses a log file containing HTTP requests and reports:
 - Number of unique IP Addresses
 - Top 3 most active IP addresses
 - Top 3 most visited URLs
This uses Java standard libraries and includes unit tests to verify core logic using JUnit


# Requirements
 - jdk 17
 - Maven 3.8.x


# How to run
mvn clean package

java -jar target/LogAnalyzerApp-1.0-SNAPSHOT.jar programming-task-example-data.log


# Running Tests
mvn test

# Assumptions
- File Path is provided as an argument
- Log format is consistent(e.g: Ip address always comes first)
- URLs are case sensitive
- malformed lines are omitted







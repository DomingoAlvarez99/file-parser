@echo off
rem mvn clean compile assembly:single

java -jar ../../../target/FileParser-1.0-jar-with-dependencies.jar excel ./test.xlsx plain_text kekw101.csv

pause
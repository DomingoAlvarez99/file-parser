FROM maven:3.6.3-adoptopenjdk-8-openj9

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean compile assembly:single

ARG JAR_FILE=target/*.jar
ARG INPUT_FILE_TYPE
ARG INPUT_FILE
COPY ${INPUT_FILE} ${INPUT_FILE}
ARG OUTPUT_FILE_TYPE
ARG OUTPUT_FILE

RUN java -jar ${JAR_FILE} \
    ${INPUT_FILE_TYPE} \
    ${INPUT_FILE} \
    ${OUTPUT_FILE_TYPE} \
    ${OUTPUT_FILE}
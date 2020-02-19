FROM openjdk:8-jdk
COPY /build/libs/bootExamples-1.0-SNAPSHOT.jar /opt/
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait
CMD /wait && java -jar /opt/bootExamples-1.0-SNAPSHOT.jar
EXPOSE 9090
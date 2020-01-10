FROM openjdk:8-jdk
COPY /build/libs/BootEverything-1.0-SNAPSHOT.jar /opt/
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait
CMD /wait && java -jar /opt/BootEverything-1.0-SNAPSHOT.jar
EXPOSE 9090
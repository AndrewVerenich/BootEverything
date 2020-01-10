FROM openjdk:8-jdk
COPY /build/libs/BootEverything-1.0-SNAPSHOT.jar /opt/
ENTRYPOINT ["java", "-jar", "/opt/BootEverything-1.0-SNAPSHOT.jar"]
EXPOSE 9090
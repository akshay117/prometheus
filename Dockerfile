FROM arm64v8/openjdk:17-ea-32-jdk

WORKDIR /opt/app

COPY target/in-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

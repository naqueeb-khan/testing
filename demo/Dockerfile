FROM eclipse-temurin:21-jdk-jammy
# reate app folder in docker container
WORKDIR /app
# copy jar file from target and rename to demo.jar by container
COPY target/*.jar demo.jar
# just documented but not bind port
EXPOSE 8186
# execute command in jocker container
ENTRYPOINT ["java","-jar","app.jar"]
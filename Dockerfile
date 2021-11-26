FROM openjdk:17-jdk-alpine

COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
CMD gunicorn --bind 0.0.0.0:$PORT wsgi
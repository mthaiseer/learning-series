FROM adoptopenjdk:11-jre-hotspot
COPY target/productapi-0.0.1-SNAPSHOT.jar productapp.jar
EXPOSE 8080
CMD [ "java", "-jar", "productapp.jar" ]
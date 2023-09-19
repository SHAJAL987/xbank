#FROM amazoncorretto:17
#COPY eureka-server.jar /app/eureka-server.jar
#COPY eureka-client.jar /app/eureka-client.jar
#WORKDIR /app
#EXPOSE 8761
#CMD ["java", "-jar", "eureka-server.jar"]

#FROM amazoncorretto:17 as builder
#WORKDIR extracted
#COPY target/*.jar registry_app.jar
#RUN java -Djarmode=layertools -jar app.jar extract

#FROM amazoncorretto:17
#WORKDIR application
#COPY --from=builder extracted/dependencies/ ./
#COPY --from=builder extracted/spring-boot-loader/ ./
#COPY --from=builder extracted/snapshot-dependencies/ ./
#COPY --from=builder extracted/application/ ./
##EXPOSE 8181
#ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]

FROM amazoncorretto:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} serviceRegistry.jar
ENTRYPOINT ["java","-jar","/serviceRegistry.jar"]
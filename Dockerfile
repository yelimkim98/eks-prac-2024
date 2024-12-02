FROM amazoncorretto:17

CMD ["./mvnw", "clean", "package"]

ARG JAR_FILE=target/*.jar

COPY ./build/libs/*.jar app.jar

ENTRYPOINT ["sh", "-c", "java -jar -DRDS_USER=${RDS_USER} -DRDS_PASSWORD=${RDS_PASSWORD} -Xms512m -Xmx1024m app.jar --spring.profiles.active=${SPRING_PROFILE}"]

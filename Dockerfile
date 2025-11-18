# Use a base image with Java pre-installed (e.g., Eclipse Temurin with JDK)
# Mysql
#
# docker run -d \
#	-v /etc/localtime:/etc/localtime:ro \
#       -v /home/infamous/mysql:/var/lib/mysql \
#	--name mysql \
#	-p 3306 \
#       --net=shadow-net \
#       --env="MYSQL_ROOT_PASSWORD=mypassword" \
#	mysql/docker
#

FROM openjdk:25-ea-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY java-api.jar /app/java-api.jar

# Expose the port your Spring Boot application listens on
EXPOSE 8080

# Define the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "java-api.jar"]
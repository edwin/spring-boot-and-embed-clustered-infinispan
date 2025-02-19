FROM java:17

LABEL base-image="java:17" \
      purpose="Spring Boot and Embeddable Clustered Infinispan"

MAINTAINER Muhammad Edwin < edwin at redhat dot com >

# set working directory at /deployments
WORKDIR /deployments

# copy my jar file
COPY target/*.jar app.jar

# gives uid
USER 185

EXPOSE 8080

# run it
CMD ["java", "-jar","app.jar"]
FROM registry.access.redhat.com/ubi8/openjdk-17-runtime:1.21

LABEL BASE_IMAGE="registry.access.redhat.com/ubi9/openjdk-17-runtime:1.21"
LABEL JAVA_VERSION="17"
LABEL PURPOSE="Spring Boot and Embeddable Clustered Infinispan"		

LABEL MAINTAINER="Muhammad Edwin < edwin at redhat dot com >"

ENV JAVA_OPTS_APPEND="-XX:TieredStopAtLevel=1 -noverify -Xlog:gc*,safepoint=debug:file=/tmp/gc.log.%p:time,uptime:filecount=5,filesize=50M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/"
ENV GC_CONTAINER_OPTIONS="-XX:+UseShenandoahGC"
ENV TZ="Asia/Jakarta"

COPY target/*.jar /deployments/application.jar
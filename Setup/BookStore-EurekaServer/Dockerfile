FROM adoptopenjdk/openjdk11:latest
COPY config /config
COPY logs /logs
ADD BookStore-EurekaServer-1.0.jar BookStore-EurekaServer-1.0.jar
ADD eureka-service-starter.sh eureka-service-starter.sh
RUN chmod 777 eureka-service-starter.sh
ENTRYPOINT ["/eureka-service-starter.sh"]
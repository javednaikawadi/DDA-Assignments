FROM adoptopenjdk/openjdk11:latest
COPY config /config
COPY logs /logs
ADD BookStore-bookservice2-1.0.jar BookStore-bookservice2-1.0.jar
ADD book-service-starter.sh book-service-starter.sh
RUN chmod 777 book-service-starter.sh
ENTRYPOINT ["/book-service-starter.sh"]
FROM confluentinc/cp-kafka-connect:7.6.0

RUN confluent-hub install --no-prompt debezium/debezium-connector-mysql:3.0.8
RUN confluent-hub install --no-prompt confluentinc/kafka-connect-jdbc:10.7.3
RUN confluent-hub install --no-prompt confluentinc/kafka-connect-elasticsearch:14.0.6

RUN mkdir -p /usr/share/java/kafka-connect-jdbc/
COPY mysql-connector-j-8.0.33.jar /usr/share/java/kafka-connect-jdbc/

USER root

RUN chmod +x /usr/share/java/kafka-connect-jdbc/mysql-connector-j-8.0.33.jar
ENV CLASSPATH="/usr/share/java/kafka-connect-jdbc/mysql-connector-j-8.0.33.jar"

USER 1000
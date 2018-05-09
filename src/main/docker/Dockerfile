FROM openjdk:8-jre-slim

COPY *.jar /opt/springboot/lib/
COPY docker-entrypoint.sh /opt/springboot/bin/
RUN chmod a+x /opt/springboot/bin/docker-entrypoint.sh

ENV JAVA_OPTS "-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
ENV SPRING_PROFILES_ACTIVE default
ENV CNAP_CLOUD local 

EXPOSE 8080

ENTRYPOINT ["/opt/springboot/bin/docker-entrypoint.sh"]
CMD ["java"]




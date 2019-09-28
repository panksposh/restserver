FROM openjdk:11
COPY . E:\Pankaj\Technical\workspace\docker_k8s\restserver
WORKDIR E:\Pankaj\Technical\workspace\docker_k8s\restserver
RUN mvn clean install
CMD ["java", "-jar","target\restserver-0.0.1-SNAPSHOT"]
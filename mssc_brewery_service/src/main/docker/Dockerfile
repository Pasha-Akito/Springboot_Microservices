FROM openjdk:17.0

EXPOSE 8080

WORKDIR application
RUN microdnf install git
RUN git clone https://github.com/Pasha-Akito/Springboot_Microservices.git
RUN ( cd ./Springboot_Microservices/mssc_brewery_bom ; ./mvnw clean install)
RUN ( cd ./Springboot_Microservices/${directoryName} ; ./mvnw clean package)
WORKDIR Springboot_Microservices/${directoryName}
ENTRYPOINT ./mvnw spring-boot:run
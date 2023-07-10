#FROM openjdk:8-jdk-alpine
##ARG JAR_FILE=target/*.jar
##COPY ${JAR_FILE} /app/Main-1.0-SNAPSHOT.jar
#COPY src home/app/src
#COPY pom.xml home/app
#RUN mvn -f home/app/pom.xml clean package
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/target/Main-1.0-SNAPSHOT.jar"]


#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8-jre-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]




# пробуем запустить локально с подклчение к бд используя команду: java -jar Main-1.0-SNAPSHOT.jar --spring.datasource.url=jdbc:mysql://localhost:3306/название_базы_данных --spring.datasource.username=имя_пользователя --spring.datasource.password=пароль_пользователя
# обрать приложение мавен - mvn clean package - получили сборку в target
# чтобы выйти из запущенного приложения через консоль ctrl + с




#  команды напоминалка:
#  docker build  -t equation:v1 .  - сборка образа
#  docker run -p 8080:8080 equation:v1 - запуск контейнера
#  docker run --rm -p 8080:8080 equation:v1 - Удалять контейнер после остановки ( предпочтительнее, чтобы не мусорить)
#  docker ps - список запущенных образов
#  docker stop <контейнер>
#  wsl --shutdown - (убить процесс.) - убить процесс винтуальной машины который висит в винде


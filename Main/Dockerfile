FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/Main-1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/target/Main-1.0-SNAPSHOT.jar"]


# logs:
# чтобы выйти из запущенного приложения через консоль ctrl + с
#добавил зависимость постгреса в пом файл
#но признаков запущенного приложения нет, локалхост работает
#сработала строчка запуска по адресу: java -jar C:\Users\Vitalii\IdeaProjects\internMafinSdet\Main\target\Main-1.0-SNAPSHOT.jar
#адрес сборки: Building jar: C:\Users\Vitalii\IdeaProjects\internMafinSdet\Main\target\Main-1.0-SNAPSHOT.jar
#заработало но тесты попадали. отключил тесты. запустил - ок
#проверил версию через mvn --version - ок, все есть
#пробую запустить сборку проекта мавен - ошибка. решаю что мавен не установлен. устанавливаю мавен - прописываю пути


#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} application.jar
#EXPOSE 8080
##исправил строку: было: ENTRYPOINT ["java","-jar","/application.jar"]
##ENTRYPOINT ["java","-jar","/app/application.jar"]
##CMD ["java","-jar","/app/application.jar"]
#ENTRYPOINT ["java","-jar","/application.jar"]



#  команды напоминалка:
#  docker build  -t equation:v1 .  - сборка образа
#  docker run -p 8080:8080 equation:v1 - запуск контейнера
#  docker ps - список запущенных образов
#  docker stop <контейнер>
#  wsl --shutdown - (убить процесс.) - убить процесс винтуальной машины который висит в винде




## не сработало!!!!! ошибка в COPY
## Указываем базовый образ, который будет использоваться для сборки приложения
#FROM openjdk:8-jdk-alpine
#
## Создаем директорию приложения внутри образа
#RUN mkdir /app
#
## Устанавливаем рабочую директорию для приложения
#WORKDIR /app
#
## Копируем файл с зависимостями приложения
#COPY my-app-1.0-SNAPSHOT.jar /app/app.jar
#
## Указываем команду, которая будет запускать приложение
#CMD ["java", "-jar", "app.jar"]
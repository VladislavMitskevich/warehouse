# Используем официальный образ OpenJDK 17 в качестве базового образа
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию в контейнере
WORKDIR /app

# Копируем JAR-файл приложения в контейнер
COPY target/warehouse-0.0.1-SNAPSHOT.jar /app/warehouse.jar

# Открываем порт 8080 для доступа к приложению
EXPOSE 8080

# Запускаем приложение при старте контейнера
CMD ["java", "-jar", "warehouse.jar"]

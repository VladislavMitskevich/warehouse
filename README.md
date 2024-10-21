# Elasticsearch Spring Boot Project

## Описание
Это тестовое задание на создание Spring Boot приложения с интеграцией Elasticsearch и PostgreSQL. Приложение предоставляет API для загрузки данных из базы данных в Elasticsearch и для поиска по загруженным данным.

## Технологии
- Java 17
- Spring Boot
- PostgreSQL
- Elasticsearch (через нативный клиент)
- Docker, Docker Compose
- Hibernate
- Maven

## Установка и запуск
### 1. Клонирование репозитория
```bash
git clone <URL_ВАШЕГО_РЕПОЗИТОРИЯ>
cd <ИМЯ_РЕПОЗИТОРИЯ>
```
### 2. Запуск Docker Compose
В корневой директории проекта выполните команду для запуска Docker Compose:
```bash
docker-compose up -d
```
Это развернет контейнеры для PostgreSQL и Elasticsearch.
### 3. Запуск приложения
После запуска контейнеров, выполните команду для запуска Spring Boot приложения:
```bash
./mvnw spring-boot:run
```
### 4. Загрузка данных в Elasticsearch
Для загрузки данных из базы данных в Elasticsearch используйте следующий API:
```
POST http://localhost:8080/api/products/load-to-elasticsearch
```
### 5. Поиск по продуктам
Для поиска по продуктам используйте следующий API:
```
GET http://localhost:8080/api/products/search?query=поисковый_запрос
```
### 6. API для управления SKU
- Получить все SKU:
  ```
  GET http://localhost:8080/api/skus
  ```
- Получить SKU по ID:
  ```
  GET http://localhost:8080/api/skus/{id}
  ```
- Создать новый SKU:
  ```
  POST http://localhost:8080/api/skus
  ```
- Удалить SKU по ID:
  ```
  DELETE http://localhost:8080/api/skus/{id}
  ```

## Структура проекта
```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.elasticsearch
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── service
│   │   │       ├── config
│   │   │       ├── mapper
│   │   │       └── exception
│   │   ├── resources
│   ├── test
│   │   └── java
│   │       └── com.example.elasticsearch
├── docker-compose.yml
├── pom.xml
└── README.md
```

## Дополнительная информация
- PostgreSQL используется для хранения исходных данных, Elasticsearch — для поиска по загруженным данным.
- Приложение поддерживает загрузку данных в индекс Elasticsearch через вызов API.
- Результаты поиска возвращают список продуктов с возможностью фильтрации по атрибутам.


## Завершение работы
Для остановки и удаления контейнеров выполните команду:
```bash
docker-compose down
```


# Банковский справочник
Веб-приложение для администрирования справочной информации о кредитно-финансовых учреждениях. (backend-part)
## Содержание

- [Стек технологий](#стек-технологий)
- [Описание проекта](#описание-проекта)
- [Инструкция для запуска](#инструкция-для-запуска)

## Стек технологий
Основной backend-стек:
- Java 17
- H2-Database
- Spring Boot
- Spring Data JPA
- Spring Web
- MapStruct
- Lombok
- JAXB

Для развертывания и тестирования:
- Docker / Docker-Compose
- SwaggerHub / SwaggerEditor
## Описание проекта
Данный проект разработан для администрирования справочной информации о кредитно-финансовых учреждениях.
- [Общий функционал](#общий-функционал)
- [Сборник справочников](#сборник-справочников)
- [Электронные сообщения](#электронные-сообщения)
### Общий функционал
- Использован архитектурный подход Spring MVC.
- Аудирование. При создании/изменении информации, сохраняются данные о дате и времени проведенных операций. 
### Сборник справочников
- Возможность хранения, добавления, изменения справочной информации в форматах описанных в *"ОБМЕН С КЛИЕНТАМИ БАНКА РОССИИ.
КОДОВЫЕ ЗНАЧЕНИЯ РЕКВИЗИТОВ ЭС"*
- Интерфейс

____
Сборник справочников:

![Сборник справочников](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/src/main/resources/readme-pictures/Screenshot_1.png?raw=true)
____
Добавление информации в справочник:

![Добавление информации в справочник](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/src/main/resources/readme-pictures/Screenshot_3.png?raw=true)
____

- Схема базы данных для справочника

____
Схема справочника:

![Схема БД - справочник](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/src/main/resources/readme-pictures/Структура_БД-Для%20справочников.drawio.png?raw=true)
____
### Электронные сообщения
- Механизм пакетного обновления. Обновление справочных данных на основе предоставляемых сведений ЦБ РФ, публикуемого по адресу: http://cbr.ru/Psystem/system_p/ (Справочник БИК – файл в формате XML).
- Механизм ручного добавления xml-файлов. Возможность добавлять собственные xml-файлы соответсвующие формату электронных сообщений ЦБ РФ.
- Интерфейс

____
Электронные сообщения:

![Электронные сообщения](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/src/main/resources/readme-pictures/Screenshot_7.png)
____
Добавление информации:

![Добавление информации](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/src/main/resources/readme-pictures/Screenshot_5.png)
____
Отображение содержимого электронного сообщения:

![Добавление информации](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/src/main/resources/readme-pictures/Screenshot_6.png)
____

- Cхема базы данных для электронных сообщений
____
Схема электронных сообщений:

![Схема БД - электрнные сообщения](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/src/main/resources/readme-pictures/Структура_БД-Для%20xml.drawio%20(2).png?raw=true)
____

Исходный код проекта:
- [Backend(server) репозиторий](https://github.com/MrRobinGoood/Bank-Info)
- [Frontend(client) репозиторий](https://github.com/Matveyx25/open-code-test)

## Инструкция для запуска
### Тестирование на удалённом сервере
Для нашего проекта запущен и доступен онлайн прототип веб-приложения(устарело).

[Прототип больше не доступен](-)
- 
Для тестирования бэкенд-сервиса вы можете воспользоваться документацией OpenAPI 3.0 на SwaggerHub

[Ссылка на OpenAPI](https://app.swaggerhub.com/apis-docs/MROBINGOOOD/Bank-Info-OpenCode-Practice/0.0.3) 
-
### Тестирование на локальной машине
____
#### Документация OpenAPI 3.0
Для нашего проекта доступна документация формата OpenAPI 3.0. [Ссылка на онлайн документацию](https://app.swaggerhub.com/apis/MROBINGOOOD/Bank-Info-OpenCode-Practice/0.0.3#/)

Для локального просмотра документации склонируйте [openapi.yaml](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/src/main/resources/openapi.yaml), а затем импортируйте его в [SwaggerEditor](https://editor.swagger.io/).
____
#### Запуск контейнеров Docker-Compose
Вы можете воспользоваться созданными контейнерами docker:
- Установите docker и docker-compose
- Склонируйте файл [docker-compose.yml](https://github.com/MrRobinGoood/Bank-Info/blob/master/backend/docker-compose/docker-compose.yml)
- Запустите docker-compose файл(из командной строки находясь в той же директории что и файл) командой ```docker compose up -d```

После этого у вас будут запущены оба контейнера client-server и вы сможете подключиться к ним по адресу ```http://localhost:3000/```

*(для доступа только к backend-сервису по адресу ```http://localhost:8081/```)*
____
#### Ручной запуск
##### Запуск backend(server)
##### Запуск frontend(client)

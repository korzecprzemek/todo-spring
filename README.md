# To-Do List Web Application 

 A simple web application built with Spring Boot

Features:
- Create, toggle and delete tasks
- Persist tasks in PostgreSQL
- Display tasks as a table (Thymeleaf)
- Import tasks from a CSV file

## Goals
- to build a robust backend architecture
- learn database engine
- deploy the application
- wrap this with a neat front-end

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Data JPA

### Database
- PostgreSQL

### Frontend
- Thymeleaf

### Build & Tools
- Maven
- Docker

## How to run

```bash
docker compose up -d
docker exec -it todo-postgres psql -U todo -d todo
mvn spring-boot:run
```
## Project structure (simplified)
```text
src/main/java/pl/pkorzec/todo
├── application        # business logic and use cases
│   ├── TaskService.java
│   └── TaskCsvReader.java
├── domain             # core domain model
│   ├── Task.java
│   ├── Priority.java
│   └── TaskNotFoundException.java
├── persistence        # data access layer (JPA)
│   └── TaskRepository.java
└── web                # web layer (controllers, DTOs)
    ├── HomeController.java
    └── TaskFormDTO.java
```


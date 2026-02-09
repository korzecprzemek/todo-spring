# To-Do List Web Application 

 A simple web application built with Spring Boot and Thymeleaf with user authentification.

Features:
- User registration and login (Spring Security and BCrypt)
- Each user has their own tasks
- Create, toggle and delete tasks
- Persist tasks in PostgreSQL
- Display tasks as a table (Thymeleaf)
- Import tasks from a CSV file
- Session-based authentification
- REST endpoints for API testing

## Goals
- to build a robust backend architecture
- learn database engine (PostgreSQL)
- learn authentication & authorization (Spring Security)
- deploy the application
- wrap this with a neat front-end

## Roadmap
- JWT authentication for REST API
- Roles (admin/users)
- Frontend (possibly Angular)
## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security

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
mvn spring-boot:run
```
## Connect to DB:
```bash
docker exec -it todo-postgres psql -U todo -d todo
```
## API testing:
```bash
curl -i -X POST http://localhost:8080/auth/signup -H "Content-Type: application/json" -d '{"username": "xxx", "password":"xxx"}'

curl -i -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username": "xxx","password:"xxx"}'
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


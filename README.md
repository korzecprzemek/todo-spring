# To-Do List Web Application 

 A web application built with Spring Boot providing REST API for managing tasks in **private lists** and **shared group lists** with authentication and authorization

Features:
- User registration and login (Spring Security and BCrypt)
- Private task lists (I called them 'Inbox')
- Group task lists shared between users
- Groups with roles(OWNER, MEMBER)
- Add users to groups(Owner only)
- Create, toggle and delete tasks
- Persist tasks in PostgreSQL
- Display tasks as a table (Thymeleaf)
- Import tasks from a CSV file
- Session-based authentification
- REST API for testing and frontend integration (in the future)

## Goals
- to build a robust backend architecture (REST + domain services)
- learn PostgreSQL and DB migrations
- learn authentication & authorization (Spring Security)
- prepare backend for future frontend
- prepare for deployment

## Roadmap
- JWT authentication for REST API
- Group permissions (editors, viewers)
- Sharing links to groups
- Roles (admin/users)
- Frontend (React/Angular)
## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security

### Database
- PostgreSQL

### Frontend
- Thymeleaf (legacy UI)

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
todo
├── application
│   ├── TaskCsvReader.java
│   ├── TaskQuery.java
│   ├── TaskService.java
│   ├── UserAuthService.java
│   └── UserService.java
├── config
│   └── SecurityConfig.java
├── domain
│   ├── Priority.java
│   ├── Task.java
│   ├── TaskNotFoundException.java
│   └── User.java
├── persistence
│   ├── TaskRepository.java
│   └── UserRepository.java
└── web
├── ApiExceptionHandler.java
├── controller
│   ├── AuthController.java
│   ├── HomeController.java
│   └── TaskRestController.java
└── dto
│   ├── LoginRequest.java
│   ├── RegisterUserRequest.java
│   ├── TaskFormDTO.java
│   └── UserResponse.java

```


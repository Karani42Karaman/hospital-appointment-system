# Hospital Appointment Management System

![Java](https://img.shields.io/badge/Java-11-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.6.6-6DB33F?logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-6DB33F?logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-5.7-4479A1?logo=mysql&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-005F0F?logo=thymeleaf&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-5.x-6DB33F?logo=springsecurity&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?logo=docker&logoColor=white)

# Hospital Appointment Management System

A web-based hospital appointment management system developed with **Java and Spring Boot**, backed by **MySQL** and **Spring Data JPA/Hibernate**.

The application models the core workflow of a hospital appointment platform, including patient registration, doctor management, appointment scheduling, authentication, authorization and web-based user interfaces.

The project also includes dedicated database design artifacts covering **functional dependencies, hospital relational modeling and relational schema design**.

---

# 1. Project Overview

The purpose of this project is to model and implement a hospital appointment management workflow using a relational database and a Java/Spring-based web application.

The system focuses on the interaction between:

```text
Patients
    │
    ├── Registration
    │
    └── Appointments
             │
             ▼
          Doctors
             │
             └── Hospital / Department structure
```

The application provides a web interface through which hospital-related operations can be managed while persistence is handled through JPA/Hibernate and MySQL.

The project was developed as a practical exercise combining:

- Relational database design
- Java backend development
- Spring Boot
- ORM with JPA/Hibernate
- Spring Security
- Server-side rendering with Thymeleaf
- Dockerized MySQL infrastructure

---

# 2. Problem Domain

A hospital appointment system needs to maintain consistent relationships between patients, doctors and appointments.

The core business flow can be represented as:

```text
Patient
   │
   │ books
   ▼
Appointment
   │
   │ assigned to
   ▼
Doctor
```

The application additionally provides authentication and protected application areas.

From an architectural perspective, the project demonstrates how a relational database can be consumed through an ORM layer instead of writing raw SQL for every persistence operation.

---

# 3. Technologies & Tools

| Category | Technology |
|---|---|
| Programming Language | **Java 11** |
| Application Framework | **Spring Boot 2.6.6** |
| Persistence | **Spring Data JPA** |
| ORM | **Hibernate** |
| Database | **MySQL 5.7** |
| SQL Dialect | **MySQL / Hibernate MySQL5InnoDBDialect** |
| Web Layer | **Spring MVC** |
| Template Engine | **Thymeleaf** |
| Security | **Spring Security 5.x** |
| Password Hashing | **BCrypt** |
| Build Tool | **Maven** |
| Containerization | **Docker Compose** |
| Database Modeling | **Draw.io** |
| Boilerplate Reduction | **Lombok** |

The Maven configuration targets Java 11 and Spring Boot 2.6.6, and includes Spring Web, Spring Data JPA, Thymeleaf, MySQL Connector, Lombok and Spring Security dependencies. 

---

# 4. Application Architecture

The project follows a conventional Spring Boot web application architecture.

```text
┌──────────────────────────────┐
│        Thymeleaf UI          │
│      HTML / Web Pages        │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│        Controllers           │
│       Spring MVC Layer       │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│          Services            │
│      Application Logic       │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│    Spring Data JPA / Repo    │
│       Persistence Layer       │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│          Hibernate           │
│             ORM              │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│          MySQL 5.7           │
└──────────────────────────────┘
```

Security is integrated at the Spring Security layer and authentication is connected to the application's user/doctor service.

---

# 5. Database Architecture & ER Design

The repository contains dedicated database design artifacts under:

```text
DBTasarım/
├── FD.drawio
├── HRS.drawio
└── İlişkisel Tasarım.drawio
```

These documents cover:

- Functional Dependency analysis
- Hospital Relational Schema
- Relational database design



The presence of separate functional-dependency and relational-design artifacts demonstrates that the database model was considered before/alongside application implementation rather than treating the database as an incidental persistence layer.

---

## 5.1 Conceptual Relationship Model

The central domain can be summarized as:

```text
                    ┌─────────────┐
                    │   Patient   │
                    └──────┬──────┘
                           │
                           │
                           ▼
                    ┌─────────────┐
                    │ Appointment │
                    └──────┬──────┘
                           │
                           │
                           ▼
                    ┌─────────────┐
                    │   Doctor    │
                    └──────┬──────┘
                           │
                           ▼
                    ┌─────────────┐
                    │ Department  │
                    └─────────────┘
```

The exact entity/attribute relationships are documented in the repository's Draw.io database-design artifacts.

---

# 6. Database Design & Normalization

The repository explicitly includes a functional dependency design document:

```text
FD.drawio
```

and a relational design document:

```text
İlişkisel Tasarım.drawio
```

This makes **functional dependency analysis and relational decomposition** an explicit part of the project.

The database design follows relational modeling principles by separating domain concepts into related entities instead of representing the complete hospital workflow in a single denormalized table.

The resulting design is consumed through JPA/Hibernate.

---

# 7. JPA / Hibernate Persistence

The application uses:

```text
Spring Data JPA
        +
Hibernate
        +
MySQL
```

rather than manually managing JDBC operations throughout the application.

This provides:

- Entity-based persistence
- Repository abstractions
- Object-relational mapping
- Automatic SQL generation
- Transaction management through Spring
- Database-independent persistence abstractions

The Maven configuration explicitly includes:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

and the MySQL JDBC driver:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```



---

# 8. Security Architecture

The application integrates **Spring Security** for authentication and request authorization.

The security configuration provides:

- Form-based authentication
- Protected authenticated routes
- Public registration/login resources
- Logout handling
- BCrypt password hashing
- Session invalidation
- JSESSIONID cookie cleanup

The application defines:

```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

and uses the configured user service for authentication.



---

## 8.1 Authentication Flow

```text
User
 │
 ▼
Login Page
 │
 ▼
Spring Security
 │
 ▼
UserDetailsService
 │
 ▼
BCrypt Password Verification
 │
 ├── Success ──► Authenticated Session
 │
 └── Failure ──► Login Failure
```

The application also configures logout behavior to invalidate the HTTP session and remove the `JSESSIONID` cookie. 

---

# 9. Web Layer

The project uses **Spring MVC + Thymeleaf** for server-side HTML rendering.

The Maven configuration includes:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```



The application also configures view controllers and UTF-8 message conversion through `WebConfig`.

Examples include:

```text
/
 /login
 /manager
```

and the application explicitly configures UTF-8 message conversion for web responses. 

---

# 10. Dockerized Database Environment

The repository includes a `docker-compose.yml` specifically for the MySQL infrastructure.

The configuration uses:

```text
MySQL 5.7
```

with:

```text
Host Port: 8889
Container Port: 3306
Username: root
Password: root
Database Character Set: UTF-8
Collation: utf8_turkish_ci
```

The MySQL container also uses a persistent Docker volume:

```text
mysql-volume
```

for database storage. 

This makes the database environment reproducible without requiring a native MySQL installation.

---

# 11. Configuration

The application is configured to connect to:

```text
jdbc:mysql://localhost:8889/HospitalAppointmentSystem
```

using the MySQL driver.

Hibernate is configured with:

```text
org.hibernate.dialect.MySQL5InnoDBDialect
```

and the current development configuration uses:

```text
spring.jpa.hibernate.ddl-auto=update
```

The application runs on:

```text
http://localhost:8088
```

The complete configuration is defined in:

```text
src/main/resources/application.properties
```



> **Security note:** The repository currently contains development database credentials directly in `application.properties`. For production usage, these values should be moved to environment variables or a secrets-management solution.

---

# 12. Example JPA Usage

A typical persistence flow follows the Spring Data model:

```text
Controller
    │
    ▼
Service
    │
    ▼
Repository
    │
    ▼
JPA Entity
    │
    ▼
Hibernate
    │
    ▼
MySQL
```

Instead of coupling business logic directly to SQL statements, the application works with domain entities and Spring Data repository abstractions.

This provides a cleaner separation between:

- Business logic
- Persistence logic
- Database implementation

---

# 13. Example SQL Scenarios

Although the application primarily accesses the database through JPA/Hibernate, the underlying relational model supports typical hospital operations.

## 13.1 Find Appointments for a Patient

```sql
SELECT *
FROM appointment
WHERE patient_id = ?
ORDER BY appointment_date;
```

---

## 13.2 Find Doctor Appointments

```sql
SELECT *
FROM appointment
WHERE doctor_id = ?
ORDER BY appointment_date;
```

---

## 13.3 Find Available Appointment Records

```sql
SELECT *
FROM appointment
WHERE doctor_id = ?
  AND appointment_date >= CURRENT_TIMESTAMP
ORDER BY appointment_date;
```

---

## 13.4 Patient–Doctor Appointment Join

```sql
SELECT
    p.id,
    p.name,
    d.id,
    d.name,
    a.appointment_date
FROM appointment a
JOIN patient p
    ON a.patient_id = p.id
JOIN doctor d
    ON a.doctor_id = d.id
ORDER BY a.appointment_date;
```

> These queries illustrate the relational access patterns represented by the application's domain. They are examples of SQL usage rather than claims that these exact statements are executed directly by the application.

---

# 14. Key Features

## Patient Management

The system supports the hospital-side patient workflow and user registration.

```text
Registration
     │
     ▼
Patient Account
     │
     ▼
Appointment Management
```

---

## Doctor Management

Doctors are represented as application users/services and are integrated into the appointment workflow.

---

## Appointment Management

The appointment domain connects:

```text
Patient ↔ Appointment ↔ Doctor
```

allowing the system to model the central hospital scheduling workflow.

---

## Authentication

Spring Security provides:

- Login
- Logout
- Protected resources
- Authentication
- Password hashing
- Session management

---

## Database Modeling

The project contains explicit database design documentation:

```text
Functional Dependencies
        ↓
Hospital Relational Design
        ↓
Relational Schema
        ↓
JPA/Hibernate Mapping
        ↓
Application
```

---

# 15. Project Directory Structure

```text
hospital-appointment-system/
│
├── .idea/
│   └── IntelliJ IDEA project configuration
│
├── .mvn/
│   └── wrapper/
│
├── DBTasarım/
│   ├── FD.drawio
│   ├── HRS.drawio
│   └── İlişkisel Tasarım.drawio
│
├── Notlarım/
│   └── Notlarım
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── karaman/
│       │           └── hospitalappointmentsystem/
│       │               │
│       │               ├── HospitalAppointmentSystemApplication.java
│       │               │
│       │               ├── config/
│       │               │   ├── SecurityConfiguration.java
│       │               │   └── WebConfig.java
│       │               │
│       │               ├── controller/
│       │               │
│       │               ├── entity/
│       │               │
│       │               ├── repository/
│       │               │
│       │               └── service/
│       │
│       └── resources/
│           ├── application.properties
│           ├── static/
│           └── templates/
│
├── docker-compose.yml
├── HELP.md
├── LICENSE
├── README.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```

The repository also contains Maven Wrapper files, Docker Compose configuration and dedicated database-design artifacts. 

---

# 16. Installation & Setup

## Requirements

Install or have available:

- Java 11
- Maven
- Docker Desktop
- Git
- MySQL client / MySQL Workbench (optional)

---

## Step 1 — Clone the Repository

```bash
git clone https://github.com/Karani42Karaman/hospital-appointment-system.git

cd hospital-appointment-system
```

---

## Step 2 — Start MySQL with Docker

Run:

```bash
docker compose up -d
```

The Compose configuration starts:

```text
mysql:5.7
```

and exposes it on:

```text
localhost:8889
```



---

## Step 3 — Create the Database

Create the application database:

```sql
CREATE DATABASE HospitalAppointmentSystem
CHARACTER SET utf8
COLLATE utf8_turkish_ci;
```

The application is configured to connect to this database. 

---

## Step 4 — Verify Database Configuration

Check:

```text
src/main/resources/application.properties
```

The expected development configuration is:

```properties
server.port=8088

spring.datasource.url=jdbc:mysql://localhost:8889/HospitalAppointmentSystem?useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update
```



---

## Step 5 — Build the Application

Using Maven:

```bash
./mvnw clean package
```

Windows:

```powershell
.\mvnw.cmd clean package
```

---

## Step 6 — Run the Application

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The application is configured to run on:

```text
http://localhost:8088
```



---

# 17. Development Workflow

The project can be run using the following development workflow:

```text
Git Clone
    │
    ▼
Docker Compose
    │
    ▼
MySQL 5.7
    │
    ▼
Spring Boot
    │
    ▼
Spring Security
    │
    ▼
Spring MVC
    │
    ▼
Thymeleaf
    │
    ▼
JPA / Hibernate
    │
    ▼
MySQL
```

This provides a complete local development environment consisting of the application and its database infrastructure.

---

# 18. Engineering Highlights

The strongest technical aspects of the project are:

### Java Backend Development

The project demonstrates practical Java 11 development using Spring Boot.

### Spring Ecosystem

The application combines:

```text
Spring Boot
Spring MVC
Spring Data JPA
Spring Security
Thymeleaf
```

within one application.

### ORM & Persistence

Hibernate handles the object-relational mapping between Java domain models and MySQL.

### Relational Database Design

The repository includes explicit:

```text
Functional Dependency Analysis
Relational Design
Hospital Schema Design
```

using Draw.io.

### Authentication & Security

Spring Security and BCrypt are used to implement authentication and password protection. 

### Containerized Infrastructure

MySQL 5.7 is reproducibly configured using Docker Compose. 

---

# 19. Production Modernization Opportunities

This project was developed with an educational/portfolio scope. For a modern production implementation, several components would be appropriate for modernization.

### Runtime & Framework

Upgrade:

```text
Java 11
Spring Boot 2.6.x
Spring Security 5.x
MySQL 5.7
```

to current supported versions.

### Configuration Security

Move:

```text
Database username
Database password
Environment-specific configuration
```

into environment variables or a dedicated secrets-management solution.

### API Architecture

A future version could expose the domain through:

```text
REST API
+
JWT/OAuth2
+
React/Angular frontend
```

instead of relying exclusively on server-side Thymeleaf rendering.

### Testing

Expand automated testing with:

```text
Unit Tests
Integration Tests
Repository Tests
Controller Tests
Security Tests
```

### Database Evolution

Introduce:

```text
Flyway / Liquibase
```

for explicit database schema versioning instead of relying on:

```properties
spring.jpa.hibernate.ddl-auto=update
```

---

# 20. What This Project Demonstrates

This project demonstrates practical experience with the complete path from **relational database modeling to a Java web application**:

```text
Functional Dependencies
        │
        ▼
Relational Database Design
        │
        ▼
MySQL
        │
        ▼
JPA / Hibernate
        │
        ▼
Spring Data
        │
        ▼
Spring Services
        │
        ▼
Spring MVC
        │
        ▼
Thymeleaf
        │
        ▼
Spring Security
```

The project therefore serves as a portfolio example of combining **database design, Java backend development, ORM, web application development and application security** in a single system.

---

# 21. Repository

**GitHub Repository**

https://github.com/Karani42Karaman/hospital-appointment-system

---

# 22. Project Status

This repository represents an educational/portfolio implementation of a hospital appointment management system.

It is intended to demonstrate software engineering, relational database design and Java/Spring development concepts rather than serve as a production healthcare platform.

---

## License

See the [`LICENSE`](LICENSE) file for project licensing information.

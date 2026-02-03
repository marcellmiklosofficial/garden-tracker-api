# Garden Sustainability Tracker API

A Java + Spring Boot backend project demonstrating REST API design,
CRUD operations, automated testing, PostgreSQL persistence, and API versioning.

## Features

- Spring Boot REST API (v1 + v2)
- PostgreSQL persistence with Spring Data JPA
- Validation + global error handling
- Automated unit + integration tests (JUnit, Mockito, MockMvc)
- Backward-compatible API versioning

## API Versions

### v1 Contract
- Field: `plantedOn`

Example:
```json
{
  "id": 1,
  "name": "Tomato",
  "plantedOn": "2026-02-01"
}
```

### v2 Contract (Breaking Change Example)
- Renamed field: plantedDate
- Added computed field: daysSincePlanted

Example:
```json
{
  "id": 1,
  "name": "Tomato",
  "plantedDate": "2026-02-01",
  "daysSincePlanted": 3
}
```

## Running locally

### Start PostgreSQL with Docker
```bash
docker compose up -d
```

### Run Spring Boot app
```bash
mvn spring-boot:run
```

### Swagger UI
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Testing
```bash
mvn test
```

### Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- JUnit 5, Mockito, MockMvc
- OpenAPI/Swagger

# Expenses Logger

A full-stack web application for tracking personal expenses. Users can log expenses, import them in bulk from CSV files, and view them aggregated by day, month, or all time.

## Features

- Add expenses with name, description, value, and date
- Autocomplete expense names based on previously entered entries
- Import expenses in bulk from CSV files
- View expenses filtered by day, month, or all time
- Running totals per aggregation period

## Tech Stack

### Backend
- **Java 8** / **Spring Boot 2**
- **MySQL** – relational database
- **JOOQ** – type-safe SQL query builder
- **Liquibase** – database schema migrations
- **OpenCSV** – CSV file parsing
- **Gradle** – build tool

### Frontend
- **Angular 2** (TypeScript)
- **ng-bootstrap** (Bootstrap 4)
- **ng2-file-upload** – CSV file upload
- **Angular CLI** – build and development server

## Prerequisites

- Java 8 or higher
- MySQL 5.7 or higher
- Node.js and npm

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/alexkovalenko/expenses-logger.git
cd expenses-logger
```

### 2. Configure the database

The application connects to MySQL with these defaults (see `server/src/main/resources/application.properties`):

```
URL:      jdbc:mysql://localhost:3306/expenses_logger
Username: root
Password: root
```

The database is created automatically on first run (`createDatabaseIfNotExist=true`). Schema migrations are applied via Liquibase.

Update `application.properties` if your database credentials differ.

### 3. Install frontend dependencies

```bash
cd client
npm install
cd ..
```

### 4. Build the project

```bash
./gradlew build
```

## Running the Application

### Backend

```bash
./gradlew :server:bootRun
```

The REST API starts on `http://localhost:8080`.

### Frontend

```bash
cd client
npm start
```

The Angular dev server starts on `http://localhost:4200` and proxies API requests to the backend.

## Database Migrations

Liquibase migrations are applied automatically at startup. To run them manually:

```bash
./gradlew :server:liquibaseUpdate
```

To regenerate JOOQ classes after schema changes:

```bash
./gradlew :server:jooqGenerate
```

## Running Tests

### Frontend unit tests

```bash
cd client
npm test
```

### Frontend end-to-end tests

```bash
cd client
npm run e2e
```

## REST API

All endpoints are prefixed with `/expense`.

| Method | Endpoint                    | Description                             |
|--------|-----------------------------|-----------------------------------------|
| POST   | `/expense`                  | Save a new expense                      |
| GET    | `/expense/name`             | Get a list of distinct expense names    |
| GET    | `/expense/{aggregationLevel}` | Fetch expenses by period (`DAY`, `MONTH`, `ALL`) |
| POST   | `/expense/import`           | Import expenses from a CSV file         |

### CSV Import Format

The CSV file must have a header row (skipped) followed by data rows with the structure:

```
date,name,value,description
21.03.2026,Groceries,45.5,Weekly shopping
```

Date format: `dd.MM.yyyy`

## Database Schema

```sql
CREATE TABLE expense (
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(20),
    description VARCHAR(100),
    value       DECIMAL(8,1),
    date        DATE
);
```

## Project Structure

```
expenses-logger/
├── buildScripts/          # Shared Gradle scripts (JOOQ, Liquibase)
├── client/                # Angular frontend
│   └── src/app/
│       ├── expense-form/      # Add expense form and CSV upload
│       ├── expenses-grid/     # Expenses table with aggregation controls
│       └── name-autocomplete/ # Name autocomplete component
├── server/                # Spring Boot backend
│   └── src/main/
│       ├── java/org/alexkovalenko/
│       │   ├── controller/    # REST endpoints
│       │   ├── service/       # Business logic
│       │   └── configuration/ # JOOQ and Cloud Foundry config
│       └── resources/
│           └── db/            # Liquibase changelog
├── build.gradle
├── settings.gradle
└── manifest.yml           # Cloud Foundry deployment descriptor
```

## Cloud Deployment

The application can be deployed to Cloud Foundry. A `manifest.yml` is provided at the project root. Bind a MySQL service named `expenses-db` before pushing.

```bash
cf push
```

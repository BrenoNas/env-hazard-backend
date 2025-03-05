# Environmental Hazard Tracker 

Environmental Hazard Tracker is a project that demonstrates a crowdsourced web application designed to report and track environmental hazards in real time. **Note:** This application is solely for demonstration purposes and is not available for production.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Architecture](#architecture)

## Introduction

This repository demonstrates how to build a robust backend API using best practices and modern frameworks. The application provides a set of RESTful endpoints for reporting environmental hazards, allowing users to submit detailed location data, descriptive information, and images. Build with technologies like Spring Boot, Spring Data JPA, and Spring Security, and follows clean architecture principles to ensure scalability, maintainability, and security.

## Features

- **User Management:**  
  Secure user registration and authentication using Spring Security.

- **Hazard Reporting:**  
  Submit hazard reports with location, description, and media attachments.

- **API Documentation:**  
  Interactive API documentation is generated automatically using SpringDoc OpenAPI.

- **Database Migrations:**  
  Schema changes are managed via Flyway, ensuring version-controlled database evolution.

## Technologies

- **Backend:** Java 17, Spring Boot, Spring Data JPA, Spring Security
- **Database:** PostgreSQL with Flyway for migrations
- **File Storage:** Amazon S3
- **API Documentation:** SpringDoc OpenAPI (Swagger UI)
- **Build Tool:** Maven
- **Other Libraries:** Lombok, Bean Validation (Jakarta Validation API)

## Architecture

The project follows **Clean Architecture** principles:

- **Core:**  
  Contains the core entities (User, Hazard, HazardType, Media) and business logic.

- **Infrastructure:**   
  Integrates with external systems like PostgreSQL, AWS S3, and manages database migrations via Flyway. 
  Exposes RESTful APIs secured with Spring Security, along with interactive API documentation.

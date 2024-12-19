# JWT Authentication in Spring Boot 3

This project demonstrates how to implement JSON Web Token (JWT) authentication in a Spring Boot 3 application. JWT provides a flexible and stateless way to secure API routes and verify user identities.

## Features

### Public API Routes:
1. **POST /auth/signup**: Register a new user.
2. **POST /auth/login**: Authenticate a user.

### Protected API Routes (requires JWT authentication):
3. **GET /users/me**: Retrieve the authenticated user.
4. **GET /users**: Retrieve a list of users.

## Prerequisites

1. **JDK 11 or higher**
2. **Maven 3.8 or higher**
3. **MySQL** (Docker or local installation)
4. **HTTP client** (Postman, Insomnia, cURL, etc.)

## Setup Instructions

### Clone the repository:
```bash
git clone https://github.com/Subash770/JWT-with-Spring-security.git


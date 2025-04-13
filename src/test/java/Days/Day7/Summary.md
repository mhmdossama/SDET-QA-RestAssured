# Authentication and Authorization in RestAssured

## Overview
Authentication verifies identity, while authorization controls access rights. RestAssured supports multiple authentication methods for API testing.

## Authentication Methods

### 1. Basic Authentication
The simplest authentication method where credentials are sent in the request header.

```java
given()
    .auth()
    .basic("username", "password")
.when()
    .get("/protected/resource")
.then()
    .statusCode(200);
```
2. Preemptive Basic Authentication
   Sends authentication upfront without waiting for server challenge
```java
given()
    .auth()
    .preemptive()
    .basic("username", "password") 
.when()
    .get("/protected/resource")
.then()
    .statusCode(200);
```
3. Form Authentication
   Used for web applications with login forms.
```java
given()
    .formParam("username", "user")
    .formParam("password", "pass")
.when()
    .post("/login")
.then()
    .statusCode(200);

```
4. OAuth 2.0
   Token-based authorization for third-party access.
```java
given()
    .auth()
    .oauth2("access_token")
.when()
    .get("/protected/resource")
.then()
    .statusCode(200);
```
5. Digest Authentication
   More secure than basic auth, uses challenge-response mechanism.
```java
given()
    .auth()
    .digest("username", "password")
.when()
    .get("/protected/resource")
.then()
    .statusCode(200);
```
Best Practices
Use preemptive auth when you know authentication is required
Always use HTTPS for secure communication
Store sensitive credentials in configuration files
Use OAuth 2.0 for third-party integrations
Consider token-based authentication for better security
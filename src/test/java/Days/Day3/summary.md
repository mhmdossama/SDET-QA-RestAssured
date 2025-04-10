# API Testing Summary

This document provides an overview of key concepts related to API testing, including path parameters, query parameters, headers, and cookies.

## What are Path Parameters and Query Parameters?

- **Path Parameters**:
    - Used to identify a specific resource in the URL path.
    - Example: In `https://api.example.com/users/123`, `123` is a path parameter.

- **Query Parameters**:
    - Used to filter or modify the response of an API request.
    - Appended to the URL after a `?`.
    - Example: In `https://api.example.com/users?age=25&sort=asc`, `age` and `sort` are query parameters.

---

## Headers

- Key-value pairs sent in HTTP requests and responses.
- Used to provide additional context or metadata about the request/response.
- Common headers include:
    - `Content-Type`: Specifies the media type of the resource.
    - `Authorization`: Contains credentials for authenticating the client.
    - `User-Agent`: Identifies the client software making the request.

---

## Cookies

- Small pieces of data stored on the client-side.
- Used to remember information about the user between requests.
- Commonly used for:
    - Session management
    - Personalization
    - Tracking

### How Cookies Work:
- Cookies are often sent and received as part of HTTP headers. For example:
    - The server sends cookies to the client using the `Set-Cookie` header.
    - The client sends cookies back to the server using the `Cookie` header.

This shows that cookies are a specific type of data transmitted via HTTP headers. 
Headers provide the mechanism for cookies to be exchanged between the client and server.
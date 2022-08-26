# Spring WEB

- Spring Boot
- Spring REST
- Thymeleaf (html, css, ajax, Spring MVC)
- Spring MVC
- Service
- Spring Data Jpa

WWW (World Wide Web)
Cases:

1. Client (Browser) -> Server (Spring Boot Application, Java EE)
2. Client (Mobile device) -> Server (Spring Boot Application, Java EE)
3. Server (Spring Boot Application, Java EE) -> Server (Spring Boot Application, Java EE)

HTTP request:
Request -> https://www.google.com/search?q=news
https -> protocol (default port 443; if HTTP -> default port 80))
www.google.com -> address of server (172.217.20.196) using DNS (domain name server)
search -> end-point, path of resource, route
q=news -> parameters (name : q, value : news)
<protocol>://<domain|ip address>[:<port>/<end-point|resource>?<parameters: name=value&name=value>]

HTTP protocol
Request:
Methods: GET, POST, PUT, DELETE, HEAD, OPTIONS, TRACE, PATCH, CONNECT
Headers: sessionId, cookies, etc.
Body: data inside request
Response:
Headers: sessionId, cookies, etc.
Body: data inside response
CODE: 200 - success

HTTPS = HTTP + secure (certificate)
FTP = File Transfer Protocol

MVC (Model - View - Controller)

Thymeleaf analogs:
GWT
JSF

# SDLC. Maven. DBMS (Database Management System)

## 1. SDLC (Software Development Life Cycle)

### Phases:

- Planning
- Define Requirements
- Design and Prototyping
- Software Development
- Testing
- Deployment
- Operations and Maintenance

### Best Practices Of Software Development:

- Source Control (Git, Mercurial, SVN, Perforce) -> Git server (GitHub, GitLab, BitBucket, Gitblit, Own computer)
- Continuous Integration (CI/CD) -> Jenkins Server (Pipelines)
- SDLC Management Systems (Jira, BitBucket, Confluence)

## 2. Maven - build system

## 3. DBMS (Database Management System)

- SQL (Structured Query Language)

```
    Операторы определения данных (Data Definition Language, DDL)
     CREATE ALTER DROP
    Операторы манипуляции данными (Data Manipulation Language, DML)
     SELECT INSERT UPDATE DELETE 
    Операторы определения доступа к данным (Data Control Language, DCL)
     GRANT REVOKE DENY
    Операторы управления транзакциями (Transaction Control Language, TCL) ACID 
     BEGIN TRANSACTION COMMIT TRANSACTION ROLLBACK TRANSACTION SAVE TRANSACTION
```

```SQL
-- DDL
CREATE DATABASE Student_data;
CREATE TABLE Student
(
    StudendId int,
    LastName  varchar(255),
    FirstName varchar(255),
    Address   varchar(255),
    Mark      int
);
ALTER TABLE Student
    ADD Total int;
ALTER TABLE Student
    DROP COLUMN Mark;
DROP TABLE Student;
DROP DATABASE Student_data;
```

```SQL
-- DML
TRUNCATE TABLE Student;
INSERT INTO students (ID, NAME, SURNAME) " +
            "
VALUES (?, ?, ?)
SELECT *
FROM Student;
```

- JDBC
- JTA
- Server (Oracle, MS SQL, PostrgeSQL, MySQL) and Embedded (H2, sqlite)
- ACID (transaction properties) ***interview***
  https://en.wikipedia.org/wiki/ACID
- Transaction isolation levels ( Serializable, Repeatable reads, Read committed, Read uncommitted ) ***interview***
  https://en.wikipedia.org/wiki/Isolation_(database_systems)

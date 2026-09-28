# Student-Registration-and-Management-System
Student Registration and Management System is a Java-based web application developed to manage student registration and student information. Its uses Java Servlets, JSP, Embedded Tomcat, JDBC, and H2 database with Maven for dependency management. The system provides separate public registration and admin functions using an MVC-style architecture.


# Student Management System - Self-Contained

A Java 17 Maven web application using embedded Tomcat and H2, designed to run from Eclipse without separately installing MySQL or Tomcat.

## Features
- Public student registration link: `/register-student`
- Admin login: `/admin-login`
- Admin dashboard with student/course counts
- View all students
- Admin-only add-student page
- Back to Dashboard/Home navigation
- Logout
- H2 SQL database initialized automatically

## Prototype admin credentials
- Username: `admin`
- Password: `admin123`

These are intentionally simple for the learning project. In a production system, credentials should be stored securely and passwords should be hashed.

## Run
Run `com.student.Main` as a Java Application in Eclipse, then open:
`http://localhost:8081/student-management-system/`

For a student-facing registration link:
`http://localhost:8081/student-management-system/register-student`

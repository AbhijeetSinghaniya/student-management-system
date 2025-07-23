# 📚 Student Management System

This project implements a Student Management System with core CRUD features for Students and Subjects, including mapping logic and validations, using Java Spring Boot and JPA.

---

## 🔧 Tech Stack

- **Language**: Java 17
- **Framework**: Spring Boot 3.x
- **ORM**: Spring Data JPA
- **Database**: MySQL (can switch to PostgreSQL easily)
- **Validation**: Jakarta Bean Validation
- **Testing**: JUnit 5, Mockito
- **API Testing**: Postman

---

## 🚀 Features Implemented

- ✅ Add, Update, Fetch, Delete a Student
- ✅ Add, Delete a Subject (with dependency checks)
- ✅ Assign a Subject to a Student
- ✅ Unassign a Subject from a Student
- ✅ Fetch student along with their subjects
- ✅ Global exception handling with meaningful errors
- ✅ DTO-layer validation and transformation
- ✅ Unit tests for key services and exception handling

---

## 🛠️ How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/AbhijeetSinghaniya/student-management-system.git
   cd student-management

2. **Configure the database**
   ```
      spring.datasource.url=jdbc:mysql://localhost:3306/student_management_system
      spring.datasource.username=your_db_username
      spring.datasource.password=your_db_password

      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true

 Note: Tables will be created automatically in the database due to the spring.jpa.hibernate.ddl-auto=update setting. No manual SQL setup is required.

3. Using Maven Wrapper Or using standard Maven (if installed globally):
   ```
       ./mvnw spring-boot:run
        mvn spring-boot:run

---

## 🧪 Testing

To run tests:

```bash
./mvnw test

---

## Postman Collection : https://drive.google.com/file/d/1gnXrTYHCB59cFsnQBQ75yDze2lanwJBe/view?usp=sharing

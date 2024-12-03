# Library Management System Backend

This is a basic implementation of a Library Management System backend using Spring Boot. The design incorporates essential design patterns to ensure code readability, flexibility, and scalability.

---

## **Features**
1. **Book Management**
    - Add, update, delete, and search for books.
2. **User Management**
    - Add, update, delete, and view user details.
3. **Borrowing and Returning**
    - Track the borrowing and returning of books.
4. **Search Functionality**
    - Search books by title, author.
---
# Solution

## User Journey
- Here user of the application will be a Library Admin.

## Class Diagram
```devicespec
Library
    - id : String
    - books : <List<Book>>
    - users : List<User>
    + addBook(details)
    + updateBook(id,details)
    + deleteBook(id)
Book
    - id : String
    - name : String
    - author : String
    - pages : Long
    - status 
User
    - id : String
    - name : String
    - books : List<Book>
```
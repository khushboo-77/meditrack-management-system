# 📐 MediTrack — Design Decisions (Comprehensive)

## 1. Introduction

MediTrack is a console-based Clinic & Appointment Management System developed using core Java.
The primary objective of this project is to demonstrate understanding of Java fundamentals,
Object-Oriented Programming principles, collections, exceptions, enums, file I/O, and basic design patterns.

The design emphasizes clarity, correctness, and extensibility rather than over-engineering.

---

## 2. Architectural Overview

### Design Choice
The application follows a layered architecture:

- Entity Layer (entity)
- Service Layer (service)
- Utility Layer (util)
- Interface Layer (interface)
- Exception Layer (exception)
- Constants Layer (constants)
- UI Layer (Main)
- Test Layer (test)

### Reasoning
This separation prevents mixing UI and business logic, improves maintainability,
and makes future extensions easier.

---

## 3. Domain Modeling & Entity Design

### Design Choice
The system models real-world clinic concepts as entities:
Person, Doctor, Patient, Appointment, Bill, and BillSummary.

### Reasoning
This mirrors real-world relationships and makes the code intuitive and easier to reason about.

---

## 4. Abstract Class: Person

### Design Choice
Person is declared as an abstract class.

### Reasoning
A Person alone has no meaning in the system. Only Doctor or Patient can exist.
This prevents invalid instantiation and enforces correct domain modeling.

---

## 5. Inheritance Strategy

### Design Choice
Doctor and Patient extend Person.

### Reasoning
Both share common attributes such as id, name, age, and phone.
Inheritance avoids duplication and demonstrates IS-A relationships.

---

## 6. Encapsulation

### Design Choice
Fields are private or protected and accessed via methods.

### Reasoning
Encapsulation protects internal state and prevents uncontrolled modification.

---

## 7. Validation Strategy

### Design Choice
Validation is centralized using a Validator utility class.

### Reasoning
Centralized validation avoids duplicated logic and ensures entities are always valid.
Validation occurs in constructors to fail fast and prevent invalid object creation.

---

## 8. Exception Handling

### Design Choice
Custom unchecked exceptions such as InvalidDataException and AppointmentNotFoundException are used.

### Reasoning
They provide domain-specific error meaning without forcing excessive try-catch blocks.

---

## 9. Service Layer Design

### Design Choice
Business logic is implemented in service classes.

### Reasoning
Services manage application state while entities remain lightweight data models.

---

## 10. Generic Storage (DataStore<T>)

### Design Choice
A generic DataStore<T> utility is used for storage.

### Reasoning
Generics provide compile-time type safety and eliminate redundant collection logic.

---

## 11. Use of Enums

### Design Choice
Enums replace string literals for AppointmentStatus and Specialization.

### Reasoning
Enums provide compile-time safety, avoid typos, and clearly represent fixed values.

---

## 12. Appointment Lifecycle

### Design Choice
Appointments have a defined lifecycle using AppointmentStatus.

### Reasoning
Explicit states prevent invalid transitions and improve readability.

---

## 13. Billing Design

### Design Choice
Billing is split across Bill, Payable, BillingService, and BillSummary.

### Reasoning
This separation demonstrates abstraction, immutability, and clean responsibility boundaries.

---

## 14. Immutability (BillSummary)

### Design Choice
BillSummary is immutable.

### Reasoning
Immutability ensures thread safety and prevents accidental modification of calculated results.

---

## 15. Singleton: IdGenerator

### Design Choice
IdGenerator is implemented as a Singleton.

### Reasoning
It guarantees unique IDs across the application and demonstrates the Singleton pattern.

---

## 16. File I/O Strategy

### Design Choice
CSV-based persistence using CSVUtil.

### Reasoning
CSV is simple, readable, and suitable for demonstrating file I/O with try-with-resources.

---

## 17. AIHelper (Optional Feature)

### Design Choice
A simple rule-based AIHelper suggests doctor specialization.

### Reasoning
This demonstrates extensibility while keeping complexity low.

---

## 18. Menu-Driven Console UI

### Design Choice
A console-based menu is used for interaction.

### Reasoning
It keeps focus on backend logic and is suitable for academic evaluation.

---

## 19. Testing Strategy

### Design Choice
Manual testing using TestRunner.

### Reasoning
This allows verification of core logic without external dependencies.

---

## 20. Final Remarks

MediTrack is designed to be clean, readable, and extensible.
The architecture supports future enhancements such as databases, REST APIs,
and advanced design patterns.

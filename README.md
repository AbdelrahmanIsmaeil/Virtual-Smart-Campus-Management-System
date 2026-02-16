# Virtual Smart Campus Management System

A comprehensive Java-based campus management system designed to streamline academic operations, resource allocation, and user management in educational institutions.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [System Architecture](#system-architecture)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Class Descriptions](#class-descriptions)
- [Contributing](#contributing)

## Overview

The Virtual Smart Campus Management System is an Object-Oriented Programming project that provides a complete solution for managing university operations. It handles person management (students, instructors, and staff), course administration, resource scheduling, and notification systems.

## Features

### Person Management
- **User Registration**: Register students, instructors, and staff members
- **Authentication**: Secure login system with email validation
- **Profile Management**: View and edit user profiles
- **Role-Based Access**: Different functionalities for students, instructors, and staff
- **Age Validation**: Enforces minimum age requirements (18+ for students, 24+ for instructors/staff)

### Course Management
- **Course Creation**: Create and manage academic courses
- **Enrollment System**: Add/remove students from courses
- **Instructor Assignment**: Assign and reassign instructors to courses
- **Course Details**: View comprehensive course information including enrolled students
- **Course Modification**: Edit course details (code, name, description)
- **Course Deletion**: Remove courses with automatic cleanup of associations

### Resource Management
- **Room Management**: Add and manage classroom spaces
- **Laboratory Management**: Create labs with equipment tracking
- **Equipment Tracking**: Add and monitor lab equipment
- **Capacity Management**: Track resource capacity limits
- **Reservation System**: View booking schedules for rooms and labs

### Scheduling System
- **Course Scheduling**: Schedule courses in specific rooms with time slots
- **Resource Booking**: Reserve rooms and labs for various purposes
- **Conflict Detection**: Automatically prevents double-booking
- **Time Slot Management**: Manage and track all reservations

### Notification System
- **Real-time Alerts**: Automated notifications for important events
- **Multi-Event Notifications**:
  - Welcome messages for new registrations
  - Course assignment notifications
  - Course enrollment confirmations
  - Schedule updates
  - Assignment creation alerts
  - Course deletion warnings
  - Account deletion notices

## System Architecture

The project follows a layered architecture pattern:

```
┌─────────────────────────────────────┐
│     Presentation Layer (UI)         │
│        - UserInterface              │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│      Service Layer                  │
│  - PersonService                    │
│  - CourseManager                    │
│  - ResourceManager                  │
│  - Scheduler / SchedulerUI          │
│  - SystemManager (Singleton)        │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│      Domain Layer                   │
│  - Person (Abstract)                │
│    └─ Student, Instructor, Staff    │
│  - Course                           │
│  - CampusResource (Abstract)        │
│    └─ Room, Lab                     │
│  - TimeSlot                         │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│      Interface Layer                │
│  - Notifiable                       │
│  - Reservable                       │
└─────────────────────────────────────┘
```

## Technologies Used

- **Language**: Java
- **Design Patterns**: 
  - Singleton Pattern (SystemManager)
  - Abstract Classes (Person, CampusResource)
  - Interface Implementation (Notifiable, Reservable)
- **Collections**: ArrayList for data management
- **Date/Time**: java.util.Date for scheduling

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java IDE (IntelliJ IDEA, Eclipse, NetBeans, or VS Code with Java extensions)
- Maven or Gradle (optional, for dependency management)

## Installation

1. **Clone or download the project**:
   ```bash
   git clone <your-repository-url>
   cd OOP_Project
   ```

2. **Compile the project**:
   ```bash
   javac -d bin src/com/mycompany/OOP_Project/**/*.java
   ```

3. **Run the application**:
   ```bash
   java -cp bin com.mycompany.OOP_Project.app.OOP_ProjectApplication
   ```

## Usage

### Main Menu Options

When you run the application, you'll see the following menu:

1. **Register Person** - Create new student, instructor, or staff accounts
2. **Login** - Access the system with existing credentials
3. **Create Course** - Add new courses to the system
4. **Assign Instructor to Course** - Link instructors with courses
5. **Add Student to Course** - Enroll students in courses
6. **View Course Details** - See course information and enrolled students
7. **View People** - List all registered users
8. **Add Room** - Create new classroom resources
9. **Add Lab** - Create new laboratory resources
10. **Schedule Course in Room** - Book rooms for course sessions
11. **Schedule Room/Lab** - Reserve resources for other purposes
12. **Add Equipment to Lab** - Track lab equipment
13. **View Reservations** - Check booking schedules
14. **Manage Records** - Edit or delete people and courses
15. **Unenroll/Reassign** - Manage student enrollments and instructor assignments
16. **Exit** - Close the application

### Example Workflows

#### Registering a Student
```
1. Select option 1 (Register Person)
2. Enter "student" as person type
3. Provide student details (ID, name, age, email, password, GPA, level)
4. System validates age (must be 18+) and email format
5. Receive welcome notification
```

#### Scheduling a Course
```
1. Create a course (option 3)
2. Add a room (option 8)
3. Assign an instructor (option 4)
4. Enroll students (option 5)
5. Schedule the course in a room (option 10)
6. All participants receive notifications
```

## Project Structure

```
OOP_Project/
│
├── app/
│   └── OOP_ProjectApplication.java      # Main entry point
│
├── domain/
│   ├── academic/
│   │   └── Course.java                  # Course entity
│   ├── person/
│   │   ├── Person.java                  # Abstract person class
│   │   ├── Student.java                 # Student implementation
│   │   ├── Instructor.java              # Instructor implementation
│   │   └── Staff.java                   # Staff implementation
│   └── resource/
│       ├── CampusResource.java          # Abstract resource class
│       ├── Room.java                    # Room implementation
│       ├── Lab.java                     # Lab implementation
│       └── TimeSlot.java                # Time slot entity
│
├── service/
│   ├── SystemManager.java               # Singleton system manager
│   ├── PersonService.java               # Person operations
│   ├── CourseManager.java               # Course operations
│   ├── ResourceManager.java             # Resource operations
│   ├── Scheduler.java                   # Scheduling logic
│   └── SchedulerUI.java                 # Scheduling UI
│
├── ui/
│   └── UserInterface.java               # Main user interface
│
└── util/
    └── interfaces/
        ├── Notifiable.java              # Notification interface
        └── Reservable.java              # Reservation interface
```

## Class Descriptions

### Core Domain Classes

#### Person (Abstract)
- Base class for all user types
- Implements `Notifiable` interface
- Common attributes: ID, name, email, password, age, address
- Abstract method: `viewProfile()`

#### Student extends Person
- Additional attributes: GPA, level, enrolled courses
- Methods: `registerCourse()`, `viewGrades()`
- GPA validation (0.0 - 4.0)

#### Instructor extends Person
- Additional attributes: department, teaching courses
- Methods: `gradeStudent()`, `createAssignment()`
- Manages course assignments

#### Staff extends Person
- Additional attributes: department, job title
- Administrative personnel representation

#### Course
- Attributes: code, name, description, instructor, students list
- Methods: `assignInstructor()`, `addStudent()`
- Manages course-instructor-student relationships

#### CampusResource (Abstract)
- Base class for campus facilities
- Implements `Reservable` interface
- Attributes: resource ID, location, capacity, reservations
- Methods: `reserve()`, `getAvailability()`

#### Room extends CampusResource
- Represents classroom spaces
- Additional attribute: room type

#### Lab extends CampusResource
- Represents laboratory spaces
- Additional attributes: lab type, equipment list
- Method: `addEquipment()`

### Service Classes

#### SystemManager (Singleton)
- Central data repository
- Manages collections of people, courses, rooms, and labs
- Provides search and CRUD operations

#### PersonService
- Handles user registration and authentication
- Email validation logic
- Person profile management

#### CourseManager
- Course CRUD operations
- Student enrollment management
- Instructor assignment logic

#### ResourceManager
- Room and lab management
- Equipment tracking
- Reservation viewing

#### Scheduler
- Scheduling logic for courses and resources
- Conflict detection
- Notification distribution

### Interfaces

#### Notifiable
- Method: `sendNotification(String message)`
- Implemented by Person classes

#### Reservable
- Methods: `reserve()`, `getAvailability()`
- Implemented by CampusResource classes

## Key Design Principles

1. **Encapsulation**: Private fields with public getters/setters
2. **Inheritance**: Person and CampusResource hierarchies
3. **Polymorphism**: Abstract methods and interface implementations
4. **Single Responsibility**: Each class has a focused purpose
5. **Singleton Pattern**: SystemManager ensures single data source
6. **Data Validation**: Email format, age restrictions, GPA limits

## Validation Rules

- **Email**: Must contain '@' and '.' in proper positions
- **Student Age**: Minimum 18 years
- **Instructor/Staff Age**: Minimum 24 years
- **GPA**: Must be between 0.0 and 4.0
- **Level**: Must be between 0 and 4
- **Unique Email**: No duplicate email addresses allowed

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Future Enhancements

- Database integration (MySQL/PostgreSQL)
- GUI implementation (JavaFX or Swing)
- Grade management system
- Attendance tracking
- Payment/Fee management
- Report generation (PDF/Excel)
- Email notification integration
- Calendar view for schedules
- Search and filter functionality
- Data export/import capabilities

## License

This project is created for educational purposes as part of an Object-Oriented Programming course.

## Authors

- Your Name - Initial work

## Acknowledgments

- Object-Oriented Programming course instructors
- Java documentation and community resources
- Contributors and testers

---

**Note**: This is an educational project demonstrating OOP principles in Java. For production use, consider adding proper exception handling, logging, data persistence, and security measures.

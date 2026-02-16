Virtual Smart Campus Management System
Project Overview

The Virtual Smart Campus Management System is a comprehensive software solution developed to manage university operations related to resources, personnel, and academic courses. It applies Object-Oriented Programming (OOP) principles to ensure modularity, scalability, and maintainability.

Implementation of OOP Principles
1. Inheritance

The system uses class hierarchies to promote reusability and specialization:

Person Hierarchy

Person (abstract base class)

Derived classes: Student, Instructor, Staff

Resource Hierarchy

CampusResource (abstract base class)

Derived classes: Room, Lab

2. Encapsulation

Encapsulation is enforced by:

Declaring state variables as private or protected

Providing controlled access via getters and setters

Embedding validation logic inside setters

3. Polymorphism

Interface Polymorphism

Notifiable: implemented by Person for notification behavior

Reservable: defines reservation behavior for resources

Inheritance Polymorphism

viewProfile() is an abstract method in Person

Overridden in derived classes for custom display

4. Abstraction

Abstraction is achieved using:

Abstract classes like Person and CampusResource

Interfaces like Notifiable and Reservable

Hiding implementation details behind simple interfaces

System Architecture
1. Main Components

Domain Layer

domain.person: Person, Student, Instructor, Staff

domain.academic: Course

domain.resource: CampusResource, Room, Lab, TimeSlot

Service Layer

SystemManager: central system controller (Singleton)

PersonService, CourseManager, ResourceManager, Scheduler

UI Layer

UserInterface: main user interaction handler (text-based)

Utility Layer

util.interfaces: Notifiable, Reservable

2. Singleton Design Pattern

The SystemManager class uses the Singleton Pattern to ensure only one instance manages all entities and processes.

Core Workflows

System Startup: Initializes UI and main loop

New Person Registration: Handles new user accounts

Course Creation: Creates academic courses

Student Enrollment: Validates and enrolls students

Course Scheduling: Assigns time slots and resources

User Interface

Text-based menu system

Organized main menu and submenus

User-friendly navigation experience

Additional Features
Integrated Notification System

Uses Notifiable to send alerts for:

User registration

Course enrollment

Instructor assignment

Assignment creation

Course deletion

Resource Reservation with Conflict Detection

Manages booking of rooms and labs

Checks for overlapping time slots

Email Validation

Strong format validation for emails

Input Validation

Checks GPA ranges, student levels, etc.

Entity Relationship Management

Manages links between students, instructors, and courses

Lab Equipment Management

Tracks and maintains lab inventories

Multi-User Support

Role-based logic for Students, Instructors, and Staff

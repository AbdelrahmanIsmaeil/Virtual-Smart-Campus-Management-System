Virtual Smart Campus Management System

A comprehensive university management system built using Object-Oriented Programming (OOP) principles.
The system manages academic courses, campus resources, and university personnel through a modular and scalable architecture.

Table of Contents

Project Overview

OOP Principles Applied

System Architecture

Design Patterns

Core Workflows

Key Features

Technology Stack

How to Run

Project Overview

The Virtual Smart Campus Management System is designed to simulate and manage university operations including:

Student and instructor management

Course creation and enrollment

Resource reservation (Rooms and Labs)

Scheduling and conflict detection

Notifications and validation

The system emphasizes clean architecture, separation of concerns, and extensibility.

OOP Principles Applied
Inheritance

The system uses hierarchical class structures for reusability and specialization.

Person Hierarchy

Person (Abstract Base Class)

Student

Instructor

Staff

Resource Hierarchy

CampusResource (Abstract Base Class)

Room

Lab

Encapsulation

Private and protected fields

Controlled access via getters and setters

Built-in validation logic within setters

Internal state protection

Polymorphism

Interface-Based Polymorphism

Notifiable → Defines notification behavior

Reservable → Defines resource reservation behavior

Inheritance-Based Polymorphism

viewProfile() declared abstract in Person

Overridden in derived classes

Abstraction

Abstract classes (Person, CampusResource)

Interfaces (Notifiable, Reservable)

Implementation details hidden behind clear APIs

System Architecture

The system follows a layered architecture approach:

Domain Layer

Handles core business entities.

domain.person → Person, Student, Instructor, Staff

domain.academic → Course

domain.resource → CampusResource, Room, Lab, TimeSlot

Service Layer

Contains business logic and system coordination.

SystemManager (Central Controller)

PersonService

CourseManager

ResourceManager

Scheduler

UI Layer

UserInterface

Text-based interactive menu system

Utility Layer

Notifiable

Reservable

Design Patterns
Singleton Pattern

SystemManager is implemented using the Singleton Design Pattern to ensure a single instance controls system-wide operations.

Core Workflows

System initialization and main loop execution

New user registration

Course creation and assignment

Student enrollment with validation

Resource booking with time conflict detection

Key Features
Integrated Notification System

User registration alerts

Course enrollment confirmation

Instructor assignment notifications

Assignment creation alerts

Course deletion alerts

Resource Reservation System

Room and lab booking

Overlapping time slot detection

Conflict prevention

Data Validation

Email format validation

GPA range checks

Student level validation

Input integrity enforcement

Entity Relationship Management

Student-course relationships

Instructor-course assignments

Resource scheduling links

Lab Equipment Tracking

Lab inventory management

Equipment monitoring

Multi-User Role Support

Student logic

Instructor logic

Staff logic

Technology Stack

Object-Oriented Programming (OOP)

Layered Architecture

Singleton Design Pattern

Interface-based design

Text-based UI

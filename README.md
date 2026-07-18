Ticketing System – Phase 1, Task B

## Overview

This is the foundational Seat & SeatComparator module for the CLI Ticketing System. It provides a type-safe, immutable value object for handling Seats with comparing support.

## What's Included

### Seat Comparator

Compare Based on
-Section
-Row
-Number

### Seat Record

A Java Record representing a seat with:
- Immutable – cannot be changed after creation.
- Validation – throws IllegalArgumentException if the Section is not a letter and the row/number is negative.
- Nice toString() – prints as Seat: A-1-1.

## Project Structure (Current State)

ticketing-cli/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── ticketing/
│   │               ├── enums/
│   │               │   └── Currency.java
│   │               ├── model/
│   │               │     └── Money.java
|   |               │    └── Seat.java
│   │               └── comparator/
│   │                    └── SeatComparator.java
│   └── test/
│       └── java/
│           └── com/
│               └── ticketing/
│                   ├── model/
│                   │    └── MoneyTest.java
│                   └── comparator/
│                       └── SeatComparatorTest.java
│
├── .gitignore
├── pom.xml
└── README.md

## How to Build & Test

This project uses Maven for dependency management and builds.

### Prerequisites

- JDK 17 or higher (tested with JDK 20)
- Maven (or use the included Maven Wrapper)

### Commands

# Clean and compile
./mvnw clean compile

# Run all tests
./mvnw test

# Run only the MoneyTest
./mvnw test -Dtest=MoneyTest

### Expected Output

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS

## Phase 1 Complete Task Breakdown

This section outlines all tasks for Phase 1: Core Java CLI (Foundations) of the Ticketing System.

**Task A – Money & Currency (COMPLETED)**

Goal: Create an immutable, type-safe money object with currency support.

Deliverables:
- Currency.java – Enum with 7 currencies (ETB, USD, EUR, GBP, CAD, SAR, UAD)
- Money.java – Record with validation, addition, and toString
- MoneyTest.java – 3 passing tests (equality, validation, addition)

Status: Done

**Task B – Seat Class + SeatComparator (COMPLETED)**

Goal: Create a seat model and a comparator that sorts seats by section -> row -> number.

Why it matters: Seats need to be sorted consistently for display, reservation, and reporting.

Step-by-Step:

1. Create Seat.java in src/main/java/com/ticketing/model/

2. Create SeatComparator.java in src/main/java/com/ticketing/comparator/

3. Create SeatComparatorTest.java in src/test/java/com/ticketing/comparator/

4. Run the Test


**Task C – In-Memory Data Store**

Goal: Create an in-memory repository that stores venues, events, seats, and reservations.

Why it matters: The CLI needs to manage data without a database. This data store will be the brain of the application.

Step-by-Step:

1. Create InMemoryDataStore.java in src/main/java/com/ticketing/repository/

2. Update models to include IDs

**Task D – JSON Persistence**

Goal: Save and load all data to/from a JSON file.

Why it matters: Data must survive between application restarts.

Step-by-Step:

1. Add Gson dependency to pom.xml

2. Create DataStoreDTO.java in src/main/java/com/ticketing/dto/

**Task E – CLI Menu**

Goal: Build a command-line interface for users to interact with the system.

Features:
- List all events
- View seats for an event
- Create a reservation
- Confirm a reservation
- Cancel a reservation
- Save data to JSON
- Load data from JSON
- Exit

Step-by-Step:

1. Create MainMenu.java in src/main/java/com/ticketing/cli/

## Task Completion Tracker

| Task | Description | Status |
| :--- | :--- | :--- |
| A | Money & Currency | Done |
| B | Seat + Comparator | Done |
| C | In-Memory Data Store | Pending |
| D | JSON Persistence | Pending |
| E | CLI Menu | Pending |

## Next Steps

1. Complete Task C – InMemoryDataStore
2. Commit and push to GitHub
3. Continue with Tasks D and E
4. Once all tasks are complete, move to Phase 2 (Concurrency, Caching, Patterns)

## License

This project is built for educational purposes as part of an internship learning plan.

Author: Samuel Wondimagegnehu (Intern)
Date: July 2026
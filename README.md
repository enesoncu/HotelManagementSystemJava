# Hotel Room Management System

## Description
The **Hotel Room Management System** is a Java-based application designed to streamline hotel operations by managing rooms, reservations, and staff efficiently. The system leverages object-oriented programming principles, ensuring modularity, scalability, and maintainability. Data persistence is achieved using CSV files, making it easy to save and retrieve information across sessions.

---

## Features
- **Room Management**: Add, update, remove, and view rooms and their statuses (Available/Occupied).
- **Reservation Management**: Book rooms for customers and manage reservation details like check-in and check-out dates.
- **Staff Management**: Manage staff details, including their roles and contact information.
- **Data Persistence**: Save and load data (rooms, reservations, staff) using CSV files for seamless data handling.

---

## Technologies Used
- **Programming Language**: Java
- **Architecture**: Object-Oriented Programming (OOP)
- **Data Storage**: CSV files for persistent data storage
- **Development Tools**: Visual Studio Code, IntelliJ IDEA

---

## Installation and Usage

### Prerequisites
- Java Development Kit (JDK) 8 or above
- A Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code)

### Steps to Run the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/enesoncu/HotelRoomManagementSystem.git
   
2. Navigate to the project directory and open it in your IDE.

3. Locate and run the Main.java file.

4. Use the console menu to interact with the system:
- Room Operations
- Person (Customer/Staff) Operations
- Reservation Operations


## Project Structure
src/
├── Main.java                # Entry point of the application
├── Room.java                # Room entity
├── RoomManager.java         # Handles room operations
├── Reservation.java         # Reservation entity
├── ReservationManager.java  # Handles reservation operations
├── Person.java              # Base class for Customer and Staff
├── Customer.java            # Customer entity
├── Staff.java               # Staff entity
├── StaffManager.java        # Handles staff operations
├── RoomOperations.java      # Interface for room operations
├── EntityUtils.java         # Generic class for CSV operations

## Key Design Highlights
### Object-Oriented Principles Applied:
- Inheritance: Customer and Staff inherit from the Person class.
- Interfaces: RoomOperations defines the structure for room management.
- Polymorphism: Overridden toString() methods provide specific representations for entities.
- Generics: EntityUtils class handles CSV operations for any entity type.
- Lambda Functions: Streamlined filtering and listing operations using lambdas.

## Example Console Menu
Hotel Management System
1. Room Operations
2. Person Operations
3. Staff Operations
4. Reservation Operations
5. Save and Exit


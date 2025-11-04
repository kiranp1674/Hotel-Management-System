# 🏨 Hotel Management System

A **Java Full Stack Desktop Application** developed using **Java Swing**, **AWT**, and **MySQL** to efficiently manage hotel operations such as room booking, customer details, employee management, and billing.  
This project follows the **MVC (Model–View–Controller)** architecture and demonstrates a practical implementation of database connectivity using JDBC.

---

## 🚀 Features

- 🔑 **Admin & Reception Login System**
- 🧾 **Room Booking and Checkout Management**
- 👤 **Customer Information Management**
- 👨‍💼 **Employee Record Maintenance**
- 💰 **Billing and Payment Tracking**
- 🏢 **Room Availability and Status View**
- 🗂 **Database Integration with MySQL**

---

## 🧰 Technologies Used

| Layer | Technology |
|-------|-------------|
| Frontend | Java Swing, AWT |
| Backend | Java (Core + JDBC) |
| Database | MySQL |
| Architecture | MVC Pattern |
| Tools Used | IntelliJ IDEA / Eclipse, MySQL Workbench |

---

## ⚙️ Installation & Setup

### 1️⃣ Prerequisites
- Java JDK 8 or above  
- MySQL Server  
- IDE (IntelliJ IDEA / Eclipse / NetBeans)

### 2️⃣ Database Configuration
1. Create a MySQL database named `hotelmanagement`.
2. Import the provided SQL file or manually create tables for customers, rooms, and employees.
3. Update the database credentials in your Java code (for example in `DBConnection.java`):
   ```java

   Connection con = DriverManager.getConnection(
       "jdbc:mysql://localhost:3306/hotelmanagement", "root", "yourpassword");

### 3️⃣ Run the Project
1. **Open the project in your IDE** (IntelliJ IDEA / Eclipse / NetBeans).  
2. **Build and run the `Main.java` file** to launch the application.  
3. The **Hotel Management System GUI** window will appear — allowing you to log in and manage hotel operations.

---

## 🖼️ Project Modules

- **Login Module** – Secure access for admins and receptionists.  
- **Dashboard Module** – Displays room availability and hotel overview.  
- **Customer Module** – Handles check-in, check-out, and details management.  
- **Employee Module** – Maintains staff records.  
- **Billing Module** – Calculates total charges and generates invoices.

---
## 🎯 Learning Outcomes

- Implemented **Java Swing UI** for real-world management systems.  
- Applied **MVC pattern** for clean and scalable code.  
- Integrated **MySQL database** using JDBC connectivity.  
- Enhanced understanding of **CRUD operations** and event-driven programming.

---

## 👨‍💻 Author

**Kiran P**  
[GitHub Profile](https://github.com/kiranp1674)

## 🏁 Conclusion

The **Hotel Management System** project successfully demonstrates how Java technologies such as **Swing**, **AWT**, and **JDBC** can be combined with **MySQL** to build a fully functional, real-world desktop application.  
It provides a seamless way to manage hotel operations including bookings, customer and employee details, and billing.  

This project strengthened the understanding of **database-driven applications**, **GUI design**, and the **MVC architecture**, making it a valuable addition to full-stack Java development experience.


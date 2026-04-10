# Tic-Tac-Toe Multiplayer (Java Web App)

## 📋 Description

**Tic-Tac-Toe Multiplayer** is a web-based application built using **Java Servlets**, **JSP**, and **AJAX**, allowing two players to compete in real-time.

The application uses **session-based communication** to manage users and game state, while **AJAX polling** ensures that both players receive live updates without refreshing the page.

This project was developed as a learning exercise to practice backend web development, client-server communication, and fundamental security concepts such as authentication and protection against SQL injection.

## 🎬 Demo

### ⚙️ Gameplay Demo
![Gameplay Demo](./assets/WhileDemo.gif)

### 💾 Real-Time Updates Demo
![Updates Demo](./assets/HeapAllocDemo.gif)

## ✨ Features

### User
- **Authentication System** – Login functionality backed by a MySQL database  
- **Session-Based Gameplay** – Each player is tracked using HTTP sessions  
- **Multiplayer Game** – Two players can play Tic-Tac-Toe in real-time  
- **Live Updates** – Game state updates automatically using AJAX polling  
- **Logout System** – Secure session termination  

### Game Logic
- **Turn-Based System** – Players alternate turns enforced on the server  
- **Win/Draw Detection** – Game outcome is computed server-side  
- **Auto Reset** – Game resets after completion  

## 🛠️ Tech Stack

- **Backend** – Java Servlets, JSP  
- **Frontend** – HTML, CSS, JavaScript  
- **AJAX** – jQuery (for asynchronous requests & polling)  
- **Database** – MySQL (via XAMPP)  
- **Server** – Apache Tomcat  
- **Architecture Concepts** – Session Management, Client-Server Model  

## 🧠 How It Works

### Session Management
- Each user is stored in an HTTP session  
- A custom `SessionListener` tracks:
  - active sessions  
  - logged-in users  
- Prevents duplicate logins and manages player state  

### Real-Time Updates (Polling)
- The client sends periodic requests using AJAX (`setInterval`)
- Game state is fetched every second from the server  
- Ensures both players stay synchronized  

### Game Logic
- Moves are processed via `GameServlet`  
- Player turns are controlled server-side  
- Game state (board, winner, draw) is shared between clients  

### Database Integration
- MySQL database stores user credentials  
- Authentication handled in backend (`DataBase.java`)  

## 🚀 Quick Start

### Prerequisites

- **Java JDK** 11+  
- **Apache Tomcat** 9+  
- **XAMPP / MySQL Server**  
- **Maven** (optional, if used)  

### Installation
```bash
# Clone the repository
git clone https://github.com/JijeuStefan/Tic-Tac-Toe.git
cd Tic-Tac-Toe
```

### Database Setup
1. Open **XAMPP**
2. Start the **Apache** and **MySQL** modules
3. Open **phpMyAdmin** or MySQL console
4. Run the following SQL commands:

```sql
CREATE DATABASE tic_tac_toe;

USE tic_tac_toe;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(255)
);
```

### Usage
1. Deploy the project on Apache Tomcat
2. Start Tomcat server
3. Open the app in your browser: http://localhost:8080/Tic_Tac_Toe2_war_exploded/
4. Open a second tab in Incognito / Private mode to simulate another player
5. Login with two different users and start playing

## 📁 Project Structure
```text
TicTacToe/
├── java/
│   ├── Listener/        # SessionListener & session tracking
│   ├── Model/           # User model
│   ├── DataBase/        # Database connection & authentication
│   ├── Login/           # Login, Logout logic
|   └── Controller/      # Active users and current game logic
|       ├── ActiveUser/  # Active user sessions
|       ├── GameLogic/   # Game logic
|       └── GameTable/   # Game board implementation
│
├── webapp/
│   ├── index.jsp        # Login page
│   ├── success.jsp      # Game interface
|   ├── error.jsp        # Invalid user page
│   ├── js/              # AJAX calls (polling, moves, sessions)
│   └── css/             # Styling
│
└── README.md            # This file
```

## 📚 Documentation

### Backend
- [Java Servlets Documentation](https://jakarta.ee/specifications/servlet/)
- [JSP (JavaServer Pages)](https://www.oracle.com/java/technologies/jspt.html)

### Frontend
- [JavaScript Documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
- [AJAX (Asynchronous JavaScript and XML)](https://developer.mozilla.org/en-US/docs/Web/Guide/AJAX)
- [jQuery Documentation](https://api.jquery.com/)

### Database
- [MySQL Documentation](https://dev.mysql.com/doc/)

### Concepts
- [HTTP Session Management](https://developer.mozilla.org/en-US/docs/Web/HTTP/Session)
- [Client-Server Architecture](https://developer.mozilla.org/en-US/docs/Learn/Server-side/First_steps/Client-Server_overview)
- [Polling (Computer Science Concept)](https://en.wikipedia.org/wiki/Polling_(computer_science))

## 📝 Usage

This project is developed for educational purposes.

It demonstrates fundamental concepts in web development, including session handling, asynchronous communication, and backend security practices.

## 👤 Author

**JijeuStefan**
- GitHub: [@JijeuStefan](https://github.com/JijeuStefan)

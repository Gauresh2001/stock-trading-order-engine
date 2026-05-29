<div align="center">

# 📈 Stock Trading Order Engine

### Enterprise-Grade Full Stack Trading Platform

A robust and scalable Stock Trading Order Engine built using **Spring Boot**, **React.js**, and **MySQL**, designed to simulate the core functionality of a real-world stock exchange. The application supports user management, stock listing, buy/sell order processing, automatic order matching, trade execution, and market depth tracking while following enterprise-level backend architecture and best practices.

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=flat-square)
![React](https://img.shields.io/badge/React.js-Frontend-blue?style=flat-square)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=flat-square)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green?style=flat-square)

</div>

---

## 📖 Project Overview

The **Stock Trading Order Engine** is a full-stack trading platform that enables users to place buy and sell orders for stocks, automatically matches compatible orders using **Price Priority** and **FIFO (First In First Out)** strategies, executes trades, and maintains an accurate order book.

The application demonstrates real-world backend development concepts including transaction management, layered architecture, DTO pattern, exception handling, API documentation, logging, and concurrency-safe order processing.

---

## ✨ Core Features

### 👤 User Management
- Register new users
- Manage account information
- Track user order history
- Maintain account balances

### 📊 Stock Management
- Add and manage stocks
- View available stocks
- Maintain stock information

### 💹 Trading Engine
- Place BUY orders
- Place SELL orders
- Automatic order matching
- FIFO order execution
- Price-priority matching
- Partial order fulfillment
- Trade execution recording

### 📚 Order Book Management
- Separate BUY order book
- Separate SELL order book
- Market depth tracking
- Open order monitoring

### 📈 Trade Management
- View trade history
- Fetch recent trades by stock
- Track executed trades

### 🏢 Enterprise Features
- Layered Architecture
- DTO Pattern
- Global Exception Handling
- Input Validation
- Transaction Management
- Swagger/OpenAPI Documentation
- SLF4J & Logback Logging
- Concurrency-Safe Processing

---

## 🏗️ System Architecture

```text
React Frontend
      │
      ▼
 REST APIs
      │
      ▼
Spring Boot Backend
      │
 ┌────┼────┐
 ▼    ▼    ▼
Controller
 Service
Repository
      │
      ▼
    MySQL
```

---

## 🛠️ Technology Stack

| Technology | Purpose |
|------------|----------|
| Java 17 | Programming Language |
| Spring Boot 3 | Backend Framework |
| Spring Data JPA | Data Access Layer |
| Hibernate | ORM Framework |
| MySQL | Relational Database |
| React.js | Frontend Framework |
| Axios | API Communication |
| Maven | Dependency Management |
| Swagger OpenAPI | API Documentation |
| Lombok | Boilerplate Reduction |
| SLF4J + Logback | Application Logging |

---

## 📂 Project Structure

```text
stock-trading-order-engine
│
├── stock-trading-backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   ├── config
│   ├── exception
│   └── enums
│
├── stock-trading-frontend
│   ├── components
│   ├── pages
│   ├── services
│   └── assets
│
├── screenshots
├── postman
└── README.md
```

---

## 🔄 Order Matching Strategy

The Trading Engine follows industry-standard order execution principles:

### Price Priority
- Highest BUY price receives priority
- Lowest SELL price receives priority

### FIFO Execution
- Orders with the same price are executed based on arrival time
- Earlier orders are matched before newer orders

### Partial Matching

Example:

```text
BUY Order  : 100 Shares @ ₹500
SELL Order : 50 Shares @ ₹500

Trade Executed : 50 Shares
Remaining BUY  : 50 Shares
```

---

## 🌐 REST API Endpoints

### User APIs

```http
POST   /users
GET    /users
```

### Stock APIs

```http
POST   /stocks
GET    /stocks
```

### Order APIs

```http
POST    /orders/buy
POST    /orders/sell
GET     /orders
GET     /orders/user/{userId}
DELETE  /orders/{id}
```

### Trade APIs

```http
GET /trades/stock/{symbol}
```

### Order Book APIs

```http
GET /orderbook/{symbol}
```

---

## 📸 Application Screenshots

Add screenshots in the following sections:

- Dashboard
- User Management
- Stock Management
- Buy/Sell Orders
- Trade History
- Order Book
- Swagger UI
- Database Tables

---

## 📖 API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

Provides interactive API testing and complete endpoint documentation.

---

## 🚀 Getting Started

### Clone Repository

```bash
git clone https://github.com/your-username/stock-trading-order-engine.git
```

---

### Backend Setup

```bash
cd stock-trading-backend
```

Configure database:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/stock_trading_db
spring.datasource.username=root
spring.datasource.password=root
```

Run Application:

```bash
mvn clean install
mvn spring-boot:run
```

Backend URL:

```text
http://localhost:8080
```

---

### Frontend Setup

```bash
cd stock-trading-frontend

npm install

npm run dev
```

Frontend URL:

```text
http://localhost:5173
```

---

## 📜 Logging

The application uses **SLF4J** and **Logback** for centralized logging.

Log file location:

```text
logs/stock-trading-engine.log
```

---

## 🧪 Testing Resources

The repository includes:

- Swagger Output Screenshots
- Postman Collection
- MySQL Database Scripts
- API Response Screenshots
- Frontend UI Screenshots
- Project Documentation

---

## 🎯 Learning Outcomes

This project demonstrates practical experience in:

- Spring Boot Development
- RESTful API Design
- Database Modeling
- DTO Pattern
- Exception Handling
- Order Matching Algorithms
- Transaction Management
- React.js Frontend Development
- Swagger Documentation
- Enterprise Application Architecture

---

## 👨‍💻 Author

### Gauresh Badgujar
**Java Full Stack Developer**

📧 Email: gauresh2211@gmail.com

💼 LinkedIn: https://www.linkedin.com/in/gauresh-badgujar-0824b7215/

---

<div align="center">

### ⭐ If you found this project useful, consider giving it a Star!

**Built with Spring Boot, React.js, MySQL, Swagger, and modern software engineering practices.**

</div>

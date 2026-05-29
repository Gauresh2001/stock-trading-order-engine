<div align="center">

# 📈 Stock Trading Order Engine

### Enterprise-Grade Full Stack Stock Trading Platform

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![React](https://img.shields.io/badge/React.js-61DAFB?style=for-the-badge&logo=react)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

### 🚀 Real-Time Order Matching • FIFO Execution • Market Depth Tracking

A powerful and scalable Stock Trading Order Engine built using Spring Boot, React.js, and MySQL. The platform simulates the core functionality of a modern stock exchange by allowing users to place buy and sell orders, automatically match orders, execute trades, and maintain an accurate order book.

</div>

---

# 🌟 Project Overview

The Stock Trading Order Engine is a full-stack enterprise-level trading platform designed to simulate how real-world stock exchanges process orders and execute trades.

The system allows users to register, manage stocks, place buy/sell orders, automatically match compatible orders based on price and FIFO strategy, generate trades, and maintain separate order books for market depth analysis.

This project demonstrates advanced backend concepts such as:

- Layered Architecture
- DTO Pattern
- Transaction Management
- Concurrency-Safe Processing
- Exception Handling
- Logging
- API Documentation
- Database Design
- Full Stack Integration

---

# 🎯 Business Scenario

In a stock exchange, users submit BUY and SELL orders for stocks.

Example:

```text
User A Places:

BUY 100 Shares of TCS @ ₹3500

User B Places:

SELL 100 Shares of TCS @ ₹3500

Result:

Trade Executed Successfully
```

The platform automatically identifies matching orders and executes trades while updating the order book.

---

# ✨ Key Features

## 👤 User Management

- Register New Users
- View User Details
- Manage User Accounts
- Track User Order History

---

## 📊 Stock Management

- Add Stocks
- View Available Stocks
- Manage Stock Information

---

## 💹 Trading Engine

- Place BUY Orders
- Place SELL Orders
- Automatic Order Matching
- FIFO Order Execution
- Price Priority Matching
- Partial Order Matching
- Trade Generation

---

## 📖 Order Book

- Separate BUY Order Book
- Separate SELL Order Book
- Market Depth Tracking
- Open Order Monitoring

---

## 📈 Trade Management

- Recent Trades
- Trade History
- Executed Trade Tracking

---

## 🏢 Enterprise Features

- DTO Pattern
- Layered Architecture
- Input Validation
- Global Exception Handling
- SLF4J Logging
- Logback Logging
- Swagger Documentation
- Transaction Management
- Concurrency Safe Processing

---

# 🏗️ System Architecture

```text
┌─────────────────────────────┐
│       React Frontend        │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│          REST APIs          │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│      Spring Boot API        │
└──────────────┬──────────────┘
               │
     ┌─────────┼─────────┐
     ▼         ▼         ▼

 Controller  Service  Repository

               │
               ▼

┌─────────────────────────────┐
│           MySQL             │
└─────────────────────────────┘
```

---

# 🛠️ Technology Stack

| Category | Technology |
|-----------|------------|
| Language | Java 17 |
| Backend | Spring Boot 3 |
| ORM | Hibernate |
| Persistence | Spring Data JPA |
| Database | MySQL |
| Frontend | React.js |
| Routing | React Router DOM |
| HTTP Client | Axios |
| API Docs | Swagger OpenAPI |
| Logging | SLF4J + Logback |
| Build Tool | Maven |

---

# 📂 Project Structure

```text
stock-trading-order-engine
│
├── stock-trading-backend
│   │
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   ├── config
│   ├── enums
│   ├── exception
│   └── resources
│
├── stock-trading-frontend
│   │
│   ├── components
│   ├── pages
│   ├── services
│   ├── assets
│   └── styles
│
├── screenshots
│
├── postman
│
└── README.md
```

---

# 🗄️ Database Design

## User

```text
id
name
email
balance
created_at
```

## Stock

```text
id
symbol
company_name
```

## Order

```text
id
user_id
stock_id
order_type
price
quantity
remaining_quantity
status
created_at
```

## Trade

```text
id
buy_order_id
sell_order_id
price
quantity
executed_at
```

---

# 🔄 Order Matching Strategy

The Trading Engine follows industry-standard matching principles.

## Price Priority

```text
Highest BUY Price Wins

Lowest SELL Price Wins
```

---

## FIFO Execution

```text
Orders having same price

↓

Earlier Order Executes First
```

---

## Partial Matching

Example:

```text
BUY Order

Quantity = 100

SELL Order

Quantity = 50

Trade Executed = 50

Remaining BUY Quantity = 50
```

---

# 📡 API Endpoints

## User APIs

```http
POST   /users
GET    /users
```

---

## Stock APIs

```http
POST   /stocks
GET    /stocks
```

---

## Order APIs

```http
POST    /orders/buy
POST    /orders/sell
GET     /orders
GET     /orders/user/{userId}
DELETE  /orders/{id}
```

---

## Trade APIs

```http
GET /trades/stock/{symbol}
```

---

## Order Book APIs

```http
GET /orderbook/{symbol}
```

---

# 📸 Screenshots

## Dashboard

```text
Add Dashboard Screenshot Here
```

---

## User Management

```text
Add Users Screenshot Here
```

---

## Stock Management

```text
Add Stocks Screenshot Here
```

---

## Orders Management

```text
Add Orders Screenshot Here
```

---

## Trade History

```text
Add Trade Screenshot Here
```

---

## Order Book

```text
Add Order Book Screenshot Here
```

---

## Swagger UI

```text
Add Swagger Screenshot Here
```

---

# 📖 Swagger Documentation

After running the backend:

```text
http://localhost:8080/swagger-ui.html
```

Swagger provides:

- API Testing
- Endpoint Documentation
- Request Validation
- Response Models

---

# 🚀 Backend Setup

### Clone Repository

```bash
git clone https://github.com/your-username/stock-trading-order-engine.git
```

---

### Move To Backend

```bash
cd stock-trading-backend
```

---

### Configure Database

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/stock_trading_db
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
```

---

### Run Backend

```bash
mvn clean install

mvn spring-boot:run
```

Backend URL:

```text
http://localhost:8080
```

---

# 🚀 Frontend Setup

### Move To Frontend

```bash
cd stock-trading-frontend
```

---

### Install Packages

```bash
npm install
```

---

### Run Application

```bash
npm run dev
```

Frontend URL:

```text
http://localhost:5173
```

---

# 📜 Logging

The application uses:

```text
SLF4J
Logback
```

Log File:

```text
logs/stock-trading-engine.log
```

---

# 🧪 Testing Resources

Included in Repository:

✅ Swagger Screenshots

✅ Postman Collection

✅ MySQL Database Script

✅ Frontend Screenshots

✅ API Response Screenshots

✅ Project Documentation

---

# 📚 Learning Outcomes

This project demonstrates practical experience in:

- Spring Boot Development
- REST API Design
- DTO Pattern
- Exception Handling
- Order Matching Algorithms
- Database Design
- Transaction Management
- React.js Development
- Swagger Documentation
- Enterprise Application Architecture

---

# 👨‍💻 Author

## Gauresh Badgujar

### Java Full Stack Developer

📧 Email:
gauresh2211@gmail.com

🔗 LinkedIn:
https://www.linkedin.com/in/gauresh-badgujar-0824b7215/

---

<div align="center">

### ⭐ If you found this project useful, don't forget to Star the Repository!

🚀 Built with Spring Boot • React.js • MySQL • Swagger • JPA • Hibernate

</div>

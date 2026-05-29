<div align="center">

# 📈 Stock Trading Order Engine

### Enterprise-Grade Full Stack Stock Trading Platform

<img width="100%" src="https://user-images.githubusercontent.com/placeholder/banner.png"/>

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![React](https://img.shields.io/badge/React.js-61DAFB?style=for-the-badge&logo=react)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger)

### 🚀 Real-Time Order Matching • FIFO Execution • Market Depth Tracking

</div>

---

# 🌟 About The Project

The Stock Trading Order Engine is a full-stack enterprise-grade trading platform that simulates the core functionality of a modern stock exchange. Users can place buy and sell orders, automatically match compatible orders based on price and time priority, execute trades, and monitor order books in real time.

This project was developed to demonstrate advanced backend engineering concepts such as transaction management, concurrent order processing, layered architecture, DTO pattern implementation, validation, exception handling, API documentation, and professional frontend integration.

---

# 🎯 Business Problem

Traditional stock exchanges process millions of orders every day. The core challenge is matching BUY and SELL orders efficiently while maintaining fairness and execution priority.

This project solves that problem by implementing:

✅ Price Priority Matching

✅ FIFO (First In First Out) Execution

✅ Partial Order Fulfillment

✅ Order Book Management

✅ Trade Execution Tracking

✅ Market Depth Monitoring

---

# 🔥 Key Highlights

<table>
<tr>
<td width="50%">

### Backend Features

- User Management
- Stock Management
- Buy Orders
- Sell Orders
- Trade Execution
- Order Matching Engine
- Partial Matching
- FIFO Strategy
- Market Depth APIs
- Order Book APIs
- Trade History
- Validation
- Exception Handling
- Logging
- Swagger Documentation

</td>

<td width="50%">

### Frontend Features

- Professional Dashboard
- User Management UI
- Stock Management UI
- Order Placement Screen
- Trade History Screen
- Market Depth Screen
- Responsive Design
- Axios Integration
- React Router Navigation

</td>
</tr>
</table>

---

# 🏢 Enterprise Architecture

```text
┌──────────────────────────┐
│      React Frontend      │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│       REST APIs          │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│    Spring Boot Backend   │
└────────────┬─────────────┘
             │
   ┌─────────┼─────────┐
   ▼         ▼         ▼

Controller  Service  Repository

             │
             ▼

┌──────────────────────────┐
│         MySQL            │
└──────────────────────────┘
```

---

# 📸 Project Preview

## Dashboard

<img src="screenshots/dashboard.png"/>

## User Management

<img src="screenshots/users.png"/>

## Stock Management

<img src="screenshots/stocks.png"/>

## Order Management

<img src="screenshots/orders.png"/>

## Trade History

<img src="screenshots/trades.png"/>

## Order Book

<img src="screenshots/orderbook.png"/>

---

# 📊 Database Design

### User Table

| Column | Type |
|----------|----------|
| id | BIGINT |
| name | VARCHAR |
| email | VARCHAR |
| balance | DECIMAL |
| created_at | TIMESTAMP |

### Stock Table

| Column | Type |
|----------|----------|
| id | BIGINT |
| symbol | VARCHAR |
| company_name | VARCHAR |

### Order Table

| Column | Type |
|----------|----------|
| id | BIGINT |
| user_id | BIGINT |
| stock_id | BIGINT |
| order_type | ENUM |
| price | DECIMAL |
| quantity | INTEGER |
| remaining_quantity | INTEGER |
| status | ENUM |

### Trade Table

| Column | Type |
|----------|----------|
| id | BIGINT |
| buy_order_id | BIGINT |
| sell_order_id | BIGINT |
| quantity | INTEGER |
| price | DECIMAL |

---

# 📈 Order Matching Example

BUY Order

```text
User A
Stock : TCS
Price : ₹3500
Quantity : 100
```

SELL Order

```text
User B
Stock : TCS
Price : ₹3500
Quantity : 50
```

Execution

```text
Executed Quantity : 50

Remaining BUY Quantity : 50

Trade Generated Successfully
```

---

# 🛠️ Technology Stack

| Category | Technology |
|-----------|------------|
| Backend | Spring Boot |
| Frontend | React.js |
| Database | MySQL |
| ORM | Hibernate |
| API Docs | Swagger |
| Build Tool | Maven |
| Logging | SLF4J / Logback |
| Validation | Jakarta Validation |
| Communication | Axios |

---

# 🚀 Future Enhancements

- JWT Authentication
- Role Based Access Control
- WebSocket Live Market Updates
- Portfolio Management
- Watchlist Feature
- Trading Analytics Dashboard
- Real-Time Price Updates
- Docker Deployment
- AWS Deployment

---

# 👨‍💻 Developed By

## Gauresh Badgujar

Java Full Stack Developer

📧 gauresh2211@gmail.com

🔗 LinkedIn:
https://www.linkedin.com/in/gauresh-badgujar-0824b7215/

---

<div align="center">

### ⭐ Don't forget to Star this Repository

Made with ❤️ using Spring Boot, React.js and MySQL

</div>

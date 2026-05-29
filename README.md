# ╔══════════════════════════════════════════════════════════════════════════════╗
# ║                    📈 STOCK TRADING ORDER ENGINE                           ║
# ║              Enterprise-Grade Full Stack Trading Platform                  ║
# ╚══════════════════════════════════════════════════════════════════════════════╝

<div align="center">

🚀 Built with Spring Boot • React.js • MySQL • Swagger • JPA • Hibernate

A professional full-stack stock trading platform that simulates the core
functionality of a real-world stock exchange with automatic order matching,
trade execution, order book management, and market depth tracking.

</div>

---

## 📌 PROJECT OVERVIEW

```text
╔══════════════════════════════════════════════════════════════╗
║                      PROJECT FEATURES                       ║
╠══════════════════════════════════════════════════════════════╣
║ ✅ User Registration & Management                           ║
║ ✅ Stock Listing & Management                               ║
║ ✅ Buy / Sell Order Placement                               ║
║ ✅ Automatic Order Matching Engine                          ║
║ ✅ FIFO Order Execution                                     ║
║ ✅ Partial Order Matching                                   ║
║ ✅ Trade Execution Records                                  ║
║ ✅ Market Depth / Order Book                                ║
║ ✅ User Order History                                       ║
║ ✅ Trade History Tracking                                   ║
║ ✅ Swagger API Documentation                                ║
║ ✅ SLF4J / Logback Logging                                  ║
║ ✅ DTO Architecture                                         ║
║ ✅ Global Exception Handling                                ║
║ ✅ Input Validation                                         ║
║ ✅ Transaction Management                                   ║
║ ✅ Concurrency Safe Processing                              ║
╚══════════════════════════════════════════════════════════════╝
```

---

## 🏗️ SYSTEM ARCHITECTURE

```text
╔══════════════════╗
║   React Frontend ║
╚══════════════════╝
          │
          ▼
╔══════════════════╗
║    REST APIs     ║
╚══════════════════╝
          │
          ▼
╔══════════════════╗
║  Spring Boot API ║
╚══════════════════╝
          │
 ┌────────┼────────┐
 ▼        ▼        ▼

Controller Service Repository

          │
          ▼

╔══════════════════╗
║      MySQL       ║
╚══════════════════╝
```

---

## ⚙️ TECHNOLOGY STACK

```text
╔══════════════════════════════════════════════════════════════╗
║                        BACKEND STACK                        ║
╠══════════════════════════════════════════════════════════════╣
║ Java 17                                                    ║
║ Spring Boot 3                                              ║
║ Spring Data JPA                                            ║
║ Hibernate                                                  ║
║ MySQL                                                      ║
║ Maven                                                      ║
║ Swagger OpenAPI                                            ║
║ SLF4J + Logback                                            ║
║ Lombok                                                     ║
╚══════════════════════════════════════════════════════════════╝
```

```text
╔══════════════════════════════════════════════════════════════╗
║                       FRONTEND STACK                        ║
╠══════════════════════════════════════════════════════════════╣
║ React.js                                                   ║
║ React Router DOM                                           ║
║ Axios                                                      ║
║ CSS3                                                       ║
║ Responsive UI                                              ║
╚══════════════════════════════════════════════════════════════╝
```

---

## 📂 PROJECT STRUCTURE

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
│
├── postman
│
└── README.md
```

---

## 📊 DATABASE ENTITIES

```text
╔════════════════════╗
║       USER         ║
╠════════════════════╣
║ id                 ║
║ name               ║
║ email              ║
║ balance            ║
║ created_at         ║
╚════════════════════╝
```

```text
╔════════════════════╗
║      STOCK         ║
╠════════════════════╣
║ id                 ║
║ symbol             ║
║ company_name       ║
╚════════════════════╝
```

```text
╔════════════════════╗
║      ORDER         ║
╠════════════════════╣
║ id                 ║
║ user_id            ║
║ stock_id           ║
║ order_type         ║
║ price              ║
║ quantity           ║
║ remaining_quantity ║
║ status             ║
║ created_at         ║
╚════════════════════╝
```

```text
╔════════════════════╗
║      TRADE         ║
╠════════════════════╣
║ id                 ║
║ buy_order_id       ║
║ sell_order_id      ║
║ price              ║
║ quantity           ║
║ executed_at        ║
╚════════════════════╝
```

---

## 🔄 ORDER MATCHING ENGINE

```text
╔══════════════════════════════════════════════════════════════╗
║                    ORDER MATCHING RULES                     ║
╠══════════════════════════════════════════════════════════════╣
║ 1. Price Priority                                          ║
║    Highest BUY Price Wins                                  ║
║    Lowest SELL Price Wins                                  ║
║                                                            ║
║ 2. FIFO Execution                                          ║
║    First Order Executed First                              ║
║                                                            ║
║ 3. Partial Matching                                        ║
║    BUY 100 Shares                                          ║
║    SELL 50 Shares                                          ║
║                                                            ║
║    Result:                                                 ║
║    Executed = 50                                           ║
║    Remaining BUY = 50                                      ║
╚══════════════════════════════════════════════════════════════╝
```

---

## 🌐 API ENDPOINTS

```text
╔══════════════════════════════════════════════════════════════╗
║                         USER APIs                           ║
╠══════════════════════════════════════════════════════════════╣
║ POST   /users                                               ║
║ GET    /users                                               ║
╚══════════════════════════════════════════════════════════════╝
```

```text
╔══════════════════════════════════════════════════════════════╗
║                        STOCK APIs                           ║
╠══════════════════════════════════════════════════════════════╣
║ POST   /stocks                                              ║
║ GET    /stocks                                              ║
╚══════════════════════════════════════════════════════════════╝
```

```text
╔══════════════════════════════════════════════════════════════╗
║                        ORDER APIs                           ║
╠══════════════════════════════════════════════════════════════╣
║ POST    /orders/buy                                         ║
║ POST    /orders/sell                                        ║
║ GET     /orders                                             ║
║ GET     /orders/user/{userId}                               ║
║ DELETE  /orders/{id}                                        ║
╚══════════════════════════════════════════════════════════════╝
```

```text
╔══════════════════════════════════════════════════════════════╗
║                        TRADE APIs                           ║
╠══════════════════════════════════════════════════════════════╣
║ GET /trades/stock/{symbol}                                  ║
╚══════════════════════════════════════════════════════════════╝
```

```text
╔══════════════════════════════════════════════════════════════╗
║                     ORDER BOOK APIs                         ║
╠══════════════════════════════════════════════════════════════╣
║ GET /orderbook/{symbol}                                     ║
╚══════════════════════════════════════════════════════════════╝
```

---

## 🚀 APPLICATION SETUP

### Backend

```bash
git clone https://github.com/your-username/stock-trading-order-engine.git

cd stock-trading-backend

mvn clean install

mvn spring-boot:run
```

```text
Backend URL:
http://localhost:8080
```

---

### Frontend

```bash
cd stock-trading-frontend

npm install

npm run dev
```

```text
Frontend URL:
http://localhost:5173
```

---

## 📖 SWAGGER DOCUMENTATION

```text
╔══════════════════════════════════════════════╗
║          Swagger UI Documentation            ║
╠══════════════════════════════════════════════╣
║ http://localhost:8080/swagger-ui.html        ║
╚══════════════════════════════════════════════╝
```

---

## 📜 LOGGING

```text
╔══════════════════════════════════════════════╗
║               LOGGING SUPPORT                ║
╠══════════════════════════════════════════════╣
║ SLF4J                                        ║
║ Logback                                      ║
║ logs/stock-trading-engine.log                ║
╚══════════════════════════════════════════════╝
```

---

## 🧪 TESTING

```text
╔══════════════════════════════════════════════╗
║             TESTING RESOURCES                ║
╠══════════════════════════════════════════════╣
║ ✅ Swagger Output Screenshots               ║
║ ✅ Postman Collection                       ║
║ ✅ MySQL Database Screenshots               ║
║ ✅ API Response Screenshots                 ║
║ ✅ Frontend UI Screenshots                  ║
╚══════════════════════════════════════════════╝
```

---

## 👨‍💻 DEVELOPER

```text
╔══════════════════════════════════════════════╗
║               GAURESH BADGUJAR               ║
╠══════════════════════════════════════════════╣
║ Java Full Stack Developer                    ║
║                                               ║
║ Email: gauresh2211@gmail.com                 ║
║ LinkedIn:                                    ║
║ linkedin.com/in/gauresh-badgujar-0824b7215   ║
╚══════════════════════════════════════════════╝
```

<div align="center">

### ⭐ Star the Repository if you found it useful!

🚀 Built with Spring Boot • React.js • MySQL

</div>

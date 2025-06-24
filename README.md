# 💸 Wallet Management Microservice

A Spring Boot-based backend microservice that simulates wallet functionality for users including loading funds, checking balance, and viewing transaction history.

---

## 🚀 Features

- Simulate loading funds into a wallet
- View real-time wallet balance
- Maintain transaction history with a ledger
- Swagger API documentation
- PostgreSQL integration
- Layered architecture (Controller, Service, Repository)
- Simulated payment gateway

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger (springdoc-openapi)
- Lombok
- Maven

---

## 📦 Folder Structur
wallet-microservice/
├── controller/ → REST API Controllers
├── dto/ → Request/Response Models (DTOs)
├── entity/ → JPA Entities
├── repository/ → Spring Data Repositories
├── service/ → Business Logic Layer
├── simulator/ → Simulated Payment Gateway Logic
├── WalletServiceApplication.java
└── application.properties


---

## 📄 API Endpoints

| Method | Endpoint               | Description                          |
|--------|------------------------|--------------------------------------|
| GET    | `/wallet/balance`      | Get the current wallet balance       |
| POST   | `/wallet/load`         | Load funds into the wallet           |
| GET    | `/wallet/transactions` | Get transaction history              |

---

## 📘 Swagger UI

After running the app, access the interactive API docs at:

##🧪 How to Test
Use Postman or Swagger UI:

Load Funds (POST)

cpp
Copy
Edit
POST /wallet/load
Body (JSON):
{
  "userId": 2,
  "amount": 500,
  "description": "Top-up"
}
Get Balance

bash
Copy
Edit
GET /wallet/balance?userId=2
Get Transactions

bash
Copy
Edit
GET /wallet/transactions?userId=2

# wallet-microservice

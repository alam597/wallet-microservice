💸 Wallet Management Microservice
A Spring Boot-based backend microservice that simulates wallet functionality for users including loading funds, checking balance, transferring money to vault, and viewing transaction history.

🚀 Features
Simulate loading funds into a wallet

View real-time wallet balance

Transfer money from wallet to vault

Maintain transaction history with a ledger

Swagger API documentation

PostgreSQL integration

Layered architecture (Controller, Service, Repository)

Simulated payment gateway

🛠️ Tech Stack
Java 21

Spring Boot

Spring Data JPA

PostgreSQL

Swagger (springdoc-openapi)

Lombok

Maven

📦 Folder Structure
css
Copy
Edit
wallet-microservice/
├── controller/         → REST API Controllers
├── dto/                → Request/Response Models (DTOs)
├── entity/             → JPA Entities
├── repository/         → Spring Data Repositories
├── service/            → Business Logic Layer
├── simulator/          → Simulated Payment Gateway Logic
├── WalletServiceApplication.java
└── application.properties
📄 API Endpoints
Method	Endpoint	Description
GET	/wallet/balance	Get the current wallet balance
POST	/wallet/load	Load funds into the wallet
GET	/wallet/transactions	Get transaction history
POST	/wallet/transfer-to-vault	Transfer money from wallet to vault
GET	/check-vault	Get current vault balance

📘 Swagger UI
Run the app and access the interactive API documentation at:

bash
Copy
Edit
http://localhost:8080/swagger-ui.html
🧪 How to Test
You can test the APIs using Postman or Swagger UI.

✅ Load Funds
POST /wallet/load

json
Copy
Edit
{
  "userId": 2,
  "amount": 500,
  "description": "Top-up"
}
✅ Get Wallet Balance
GET /wallet/balance?userId=2

✅ Get Transaction History
GET /wallet/transactions?userId=2

✅ Transfer to Vault
POST /wallet/transfer-to-vault

json
Copy
Edit
{
  "userId": 2,
  "amount": 200,
  "description": "Saving funds"
}
✅ Get Vault Balance
GET /check-vault?userId=2

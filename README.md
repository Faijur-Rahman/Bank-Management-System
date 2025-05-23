# Bank Management System

![Java](https://img.shields.io/badge/Java-Primary%20Language-orange)

This repository contains a Bank Management System implemented in Java. The system provides functionalities related to managing bank accounts, transactions, and customer information.

## Key Features and Highlights

- Create and manage bank accounts
- Perform transactions such as deposits, withdrawals, and transfers
- View transaction history and account details
- Secure authentication and authorization mechanisms

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/username/Bank-Management-System.git
   ```

2. Compile the Java files:
   ```bash
   javac *.java
   ```

3. Run the main program:
   ```bash
   java Login
   ```

## Usage

```java
// Create a new bank account
BankAccount account = new BankAccount("John Doe", 1000.00);

// Perform a deposit
account.deposit(500.00);

// Perform a withdrawal
account.withdraw(200.00);

// Transfer funds between accounts
BankAccount recipientAccount = new BankAccount("Jane Smith", 1500.00);
account.transfer(recipientAccount, 300.00);
```

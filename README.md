# E-Commerce API Project

## Overview

This is a Spring Boot-based e-commerce API project. It provides a set of RESTful endpoints for managing an online store, including product listing, user registration, and payment transactions. The project also includes test automation using Selenium.

## Features

- **Product Listing**: Endpoints to list products, get product details, add, update, and delete products.
- **User Registration**: Endpoints for user registration, login, and profile management.
- **Payment Transactions**: Endpoints for handling payment transactions.
- **Test Automation**: Integration with Selenium for automated testing of the application.

## Prerequisites

- Java 11 or later
- Maven 3.6.0 or later
- [MySQL](https://www.mysql.com/) (or other database systems)
- [Selenium](https://www.selenium.dev/) (for test automation)

## Endpoints
### Product Management
- GET /products/list - Get all products
- GET /products/{id} - Get product by ID
- POST /products/list - Create a new product
- PUT /products/{id} - Update product
- DELETE /products/{id} - Delete product
### User Management
- POST /users/register - Register a new user
- POST /users/login - Login user
- GET /users/{id} - Get user profile
### Payment Transactions
- POST /payments - Process a payment

## User Registeration
<img src="https://github.com/user-attachments/assets/d1d394a5-7f83-4679-b95a-6e774febd1f5" alt="User Registration" width="400"/>

## Product List Mock Datas
<img src="https://github.com/user-attachments/assets/d7080611-8a42-40cf-bcae-2b07fd997735" alt="Product List Mock Datas" width="400"/>


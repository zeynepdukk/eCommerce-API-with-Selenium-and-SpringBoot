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
- GET /api/products - Get all products
- GET /api/products/{id} - Get product by ID
- POST /api/products - Create a new product
- PUT /api/products/{id} - Update product
- DELETE /api/products/{id} - Delete product
### User Management
- POST /api/users/register - Register a new user
- POST /api/users/login - Login user
- GET /api/users/{id} - Get user profile
### Payment Transactions
- POST /api/payments - Process a payment

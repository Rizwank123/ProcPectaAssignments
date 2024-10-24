# Coding Interview Project - Prospecta

## Overview

This project consists of two tasks that utilize the [Fake Store API](https://fakestoreapi.com) to list and add products by category, along with a discussion on API security and reliability considerations.

## Technologies Used

- **Language**: Java (or any preferred language)
- **JSON Parsing**: Jackson (for JSON serialization/deserialization)
- **HTTP Requests**: `HttpURLConnection` for making API requests
- **API Endpoint**: [Fake Store API](https://fakestoreapi.com)

---

## Task 1: List Product Details by Category

### Description

Create an API that retrieves product details (such as title, price, description, etc.) based on the category passed as an input parameter.

### API Endpoint

**Method**: `GET`  
**URL**: `/products/category/{category}`  
**Example**: [GET /products/category/jewelery](https://fakestoreapi.com/products/category/jewelery)

### Implementation Steps

1. Make an HTTP GET request to the `/products/category/{category}` endpoint.
2. Parse the response and return product details including title, price, and description.
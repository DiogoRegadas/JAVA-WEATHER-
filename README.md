# JavaWeather — Real-Time Forecast Tool 🌤️
### API Integration & Data Visualization — Java Command-Line Project

![Status](https://img.shields.io/badge/status-active-blue)
![Type](https://img.shields.io/badge/project-API--study-orange)
![Stack](https://img.shields.io/badge/stack-Java%20%7C%20JSON-green)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

**JavaWeather** is a desktop application that bridges the gap between raw meteorological data and user-friendly visualization. By integrating with professional Weather APIs, this tool fetches real-time atmospheric conditions, parsing complex JSON responses into a clean and readable interface.

This project focuses on **Network I/O**, **Asynchronous Request Handling**, and **External Library Integration**.

---

## 🎯 **Project Goals**

- **RESTful API Consumption:** Master the process of making HTTP requests to external cloud services.
- **JSON Parsing:** Efficiently extract specific data points (temperature, humidity, wind speed) from nested JSON structures.
- **Dynamic GUI:** Update the User Interface in real-time based on API responses.
- **Error Resilience:** Implement robust error handling for network timeouts or invalid location queries.
- **Credential Security:** Manage API keys through external files to follow security best practices.

---

## 🛠️ **Technologies Used**

### **Backend & Connectivity**
- **Java 17+**: Core language and logic.
- **HttpURLConnection / HttpClient**: For managing GET requests to weather providers.
- **org.json / JSON-Simple**: For deserializing and parsing the weather data.

### **Patterns & Tools**
- **API Handler Class**: Dedicated logic to manage endpoint URLs and parameters.
- **Git & GitHub**: Version control and project documentation.

---

## 📦 **Core Features**

### 🔹 **1. Global City Search**
- Fetches weather data for any city worldwide by communicating with global meteorological databases.

### 🔹 **2. Real-Time Metrics**
- Displays current temperature and conditions.
- Automatic unit conversion (Celsius/Fahrenheit).

### 🔹 **3. Status Recognition**
- The application identifies weather states (Clear, Rain, Storm, Snow) and updates the UI accordingly to give visual feedback to the user.

---

## 🧩 **Architecture Overview**

The project follows a "Service-Oriented" logic:
1. **The Request:** The user inputs a city name, triggering the `WeatherService`.
2. **The Fetch:** The application constructs a secure URL with an API Key and sends a request.
3. **The Parse:** The raw JSON string is converted into a JSONObject.

---

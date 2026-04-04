# 🛍️ Aura Bling — Advanced Selenium Test Automation Framework

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Log4j](https://img.shields.io/badge/Log4j-D22128?style=for-the-badge&logo=apache&logoColor=white)
![ExtentReports](https://img.shields.io/badge/ExtentReports-5.1.2-blue?style=for-the-badge)

---

## 📌 Project Overview

**Aura Bling** is a production-grade, end-to-end UI test automation framework built for an e-commerce jewellery web application. The framework is designed with scalability, reusability, and real-world testing best practices in mind.

It supports **Data Driven Testing (DDT)**, **Parallel Test Execution**, **Cross-Browser Testing**, **Selenium Grid with Docker**, **automated screenshot capture on failure**, **email notifications**, and **rich HTML reporting via ExtentReports**.

---

## 🚀 Key Features

| Feature | Description |
|---|---|
| ✅ **Selenium WebDriver 4.x** | Latest Selenium with enhanced Grid support |
| ✅ **Data Driven Testing (DDT)** | Test data managed via Apache POI (Excel) |
| ✅ **Parallel Test Execution** | Multi-threaded execution using TestNG |
| ✅ **Selenium Grid + Docker** | Distributed cross-browser testing via Docker Compose |
| ✅ **Page Object Model (POM)** | Clean separation of test logic and UI elements |
| ✅ **ExtentReports** | Rich, interactive HTML test reports |
| ✅ **Log4j2 Logging** | Detailed execution logs at every step |
| ✅ **Screenshot on Failure** | Auto-captures screenshots when a test fails |
| ✅ **Email Notification** | Sends test results via email after execution |
| ✅ **Maven Build** | Dependency management and CI-ready build |
| ✅ **Group Testing** | TestNG groups for smoke, regression, sanity runs |

---

## 🧰 Tech Stack

| Tool / Technology | Version | Purpose |
|---|---|---|
| Java | 17+ | Core programming language |
| Selenium WebDriver | 4.40.0 | Browser automation |
| TestNG | 7.12.0 | Test framework & parallel execution |
| Apache Maven | 3.x | Build & dependency management |
| Apache POI | 5.5.1 | Excel-based Data Driven Testing |
| Log4j2 | 2.25.3 | Logging framework |
| ExtentReports | 5.1.2 | HTML test reporting |
| Docker | Latest | Containerized Selenium Grid |
| Selenium Grid | 4.20.0 | Distributed test execution |
| Commons Email | 1.6.0 | Email notification of test results |

---

## 📁 Project Structure

```
Aura_Bling/
├── src/
│   └── test/
│       └── java/
│           ├── base/               → Base test setup & teardown
│           ├── pages/              → Page Object Model classes
│           ├── tests/              → Test classes
│           └── utils/              → Utility helpers (Excel, Screenshot, Email)
├── testData/                       → Excel files for DDT
├── reports/                        → ExtentReports HTML output
├── screenshots/                    → Auto-captured failure screenshots
├── logs/                           → Log4j execution logs
├── master.xml                      → Main TestNG suite
├── ParallelTesting.xml             → Parallel execution suite
├── GroupTest.xml                   → Group-based test suite
├── Grid-standalone.xml             → Selenium Grid standalone suite
├── Grid-Docker.xml                 → Selenium Grid with Docker suite
├── docker-compose.yaml             → Docker setup for Selenium Grid
├── run.bat                         → Windows batch script to run tests
├── Commands.txt                    → Useful commands reference
└── pom.xml                         → Maven configuration
```

---

## ⚙️ Prerequisites

Make sure the following are installed on your system:

- Java JDK 17 or higher
- Apache Maven 3.x
- Google Chrome / Firefox / Edge browser
- Docker Desktop (for Grid execution)
- Git

---

## 🏃 How to Run Tests

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/shantanukekane/Aura_Bling.git
cd Aura_Bling
```

### 2️⃣ Run All Tests (Default Suite)
```bash
mvn clean test
```

### 3️⃣ Run Parallel Tests
```bash
mvn clean test -DsuiteXmlFile=ParallelTesting.xml
```

### 4️⃣ Run Group Tests (e.g., Smoke / Regression)
```bash
mvn clean test -DsuiteXmlFile=GroupTest.xml
```

### 5️⃣ Run Tests on Selenium Grid (Standalone)
```bash
mvn clean test -DsuiteXmlFile=Grid-standalone.xml
```

### 6️⃣ Run Tests on Selenium Grid with Docker
```bash
# Start the Docker Grid
docker-compose up -d

# Run tests
mvn clean test -DsuiteXmlFile=Grid-Docker.xml

# Stop Docker Grid
docker-compose down
```

---

## 🐳 Docker Selenium Grid Setup

The `docker-compose.yaml` spins up a Selenium Hub along with Chrome and Firefox nodes for distributed cross-browser testing.

```bash
# Start Grid
docker-compose up -d

# Check running containers
docker ps

# View Grid console
http://localhost:4444
```

---

## 📊 Test Reports

After test execution, HTML reports are generated in the `/reports` directory.

Open the report:
```
reports/index.html
```

The ExtentReports dashboard includes:
- Test execution summary
- Pass / Fail / Skip statistics
- Step-by-step logs
- Screenshot thumbnails for failed tests
- Execution timeline

---

## 📸 Screenshot on Failure

When a test fails, the framework automatically captures a screenshot and:
- Saves it in the `/screenshots` folder with a timestamp
- Embeds it directly in the ExtentReports HTML report

---

## 📧 Email Notification

After test execution, an automated email is sent with the test results summary using Apache Commons Email. Configure the email settings in the utility class before use.

---

## 📋 Test Suites Available

| Suite File | Description |
|---|---|
| `master.xml` | Runs all tests |
| `ParallelTesting.xml` | Runs tests in parallel threads |
| `GroupTest.xml` | Runs tests by group (smoke/regression) |
| `Grid-standalone.xml` | Runs on Selenium Grid (standalone server) |
| `Grid-Docker.xml` | Runs on Selenium Grid (Docker containers) |

---

## 👨‍💻 Author

**Shantanu Nitin Kekane**
QA Engineer | Manual & Automation Testing | API Testing | Selenium | Docker | Cucumber

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/shantanu-kekane)
[![GitHub](https://img.shields.io/badge/GitHub-121011?style=for-the-badge&logo=github&logoColor=white)](https://github.com/shantanukekane)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:kekaneshantanu@gmail.com)

---

## 📄 License

This project is open source and available.

---

> ⭐ If you found this project helpful, please consider giving it a star on GitHub!

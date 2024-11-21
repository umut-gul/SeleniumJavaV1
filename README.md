
# **Selenium Automation Project**

## **Project Overview**
This project is a Selenium-based automation framework for testing web applications. The framework is built using **Java**, **Maven**, and follows the **Page Object Model (POM)** design pattern. It is designed for end-to-end UI testing with maintainable and reusable code.


## **Features**
- **Page Object Model (POM):** Ensures modular and maintainable test scripts.
- **Browser Management:** Automated WebDriver setup using WebDriverManager.
- **Assertions:** Test validation using **TestNG** and **JUnit**.
- **Reporting:** Basic logs and outputs for debugging.
- **Java 17 Compatibility:** Utilizes modern Java features.

## **Pre-requisites**
1. **Java Development Kit (JDK) 17 or higher**  
   Ensure `JAVA_HOME` is set to the JDK path.
   ```bash
   java -version
   ```
2. **Maven**  
   Verify Maven is installed:
   ```bash
   mvn -version
   ```
3. **Web Browser**  
   Supported browsers include Chrome, Firefox, and Edge.
   
## **Setup Instructions**
1. Clone this repository:
   ```bash
   git clone https://github.com/umut-gul/SeleniumJavaV1.git
   ```
2. Navigate to the project directory:
   ```bash
   cd SeleniumJavaV1
   ```
3. Install dependencies:
   ```bash
   mvn clean install
   ```
## **How to Run Tests**
1. **Run Tests with Maven:**
   ```bash
   mvn test
   ```
2. **Run Specific Test Class:**  
   Replace `TestClassName` with the name of your test class:
   ```bash
   mvn -Dtest=TestClassName test
   ```
## **Technologies Used**
- **Selenium Java:** For browser automation.
- **TestNG & JUnit:** For test management and assertions.
- **WebDriverManager:** For automated driver downloads.
- **Maven:** Build and dependency management.

## **Key Dependencies**
The project uses the following dependencies (managed in `pom.xml`):
- **Selenium Java (v4.26.0)**
- **WebDriverManager (v5.9.2)**
- **TestNG (v7.7.0)**
- **JUnit (v4.13.1)**
- **SLF4J (v2.0.13)**









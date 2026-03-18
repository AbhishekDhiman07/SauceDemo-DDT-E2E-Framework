# 🚀 SauceDemo Advanced E2E & DDT Framework
![Selenium CI/CD](https://github.com/AbhishekDhiman07/SauceDemo-DDT-E2E-Framework/actions/workflows/maven.yml/badge.svg)
[![Live Report](https://img.shields.io/badge/View-Live_Report-brightgreen)](https://AbhishekDhiman07.github.io/SauceDemo-DDT-E2E-Framework/)
A high-performance Selenium WebDriver framework built with **Java 17** and **TestNG**. This project demonstrates advanced SDET principles, including parallel thread management, CI/CD integration, and deep defect analysis of modern React-based UI states.
---
## 🌐 How to Access the Live Site
You can view the latest automation execution results and dashboards directly in your browser:
👉 **[View Live Extent Report Dashboard](https://AbhishekDhiman07.github.io/SauceDemo-DDT-E2E-Framework/)**
*This site is automatically updated via GitHub Actions after every code push, providing real-time visibility into the application's health.*
---
## 🏗️ Core Engineering Highlights
* **Parallel Execution:** Implements `ThreadLocal<WebDriver>` to ensure thread-safety and high-concurrency execution, reducing test cycle time by ~50%.
* **Data-Driven Architecture (DDT):** Utilizes TestNG `@DataProvider` to separate test logic from data, allowing seamless validation of multiple user personas (`standard_user`, `problem_user`).
* **React State Bypass:** Implements **Native JavaScript Property Injection** to handle asynchronous React UI updates where traditional `sendKeys()` fails to trigger internal state changes.
* **CI/CD Pipeline:** Fully integrated with **GitHub Actions** for automated headless execution on every push to the `main` branch.
* **Professional Reporting:** Automated **Extent Reports 5** generation with embedded failure screenshots and environmental metadata.
---
## 🐞 Bug Report: Functional Regression (Problem User)
The framework intentionally identifies and documents a critical functional defect within the `problem_user` profile:
* **Defect:** The "Checkout" form ignores "Last Name" input and the "Continue" button becomes unresponsive.
* **Analysis:** Using JS Event Dispatchers, we confirmed the issue lies in the React state-binding rather than the DOM element availability.
* **Status:** **REPRODUCED** (Verified via Automation).
---
## 📂 Project Structure
* `src/test/java/base`: Driver initialization & ThreadLocal management.
* `src/test/java/pages`: Page Object Model (POM) with JS Injection logic.
* `src/test/java/testcases`: The E2E test suites and DataProviders.
* `.github/workflows`: CI/CD YAML configuration for cloud execution.
* `docs/`: Hosted Extent Reports for GitHub Pages.
---
## 🚀 How to Run Locally
1.  **Clone the repo:**
    ```bash
    git clone [https://github.com/AbhishekDhiman07/SauceDemo-DDT-E2E-Framework.git](https://github.com/AbhishekDhiman07/SauceDemo-DDT-E2E-Framework.git)
    ```
2.  **Run in Headed Mode:**
    ```bash
    mvn clean test
    ```
3.  **Run in Headless Mode (CI Simulation):**
    ```bash
    mvn clean test -Dheadless=true
    ```

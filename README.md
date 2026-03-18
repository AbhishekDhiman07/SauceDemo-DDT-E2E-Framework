# SauceDemo Parallel DDT Framework 🚀
A professional-grade Selenium WebDriver framework built with **Java** and **TestNG**. This project demonstrates advanced automation techniques, including handling asynchronous React states and executing high-concurrency test suites.
## ✨ Key Engineering Highlights
* **Data-Driven Testing (DDT):** Utilizes TestNG `@DataProvider` to inject multiple user personas (`standard_user`, `problem_user`) into a single test logic.
* **Parallel Execution:** Configured to run browser instances in parallel using `ThreadLocal` WebDriver, reducing total execution time by over 50%.
* **React State Bypass:** Implements **Native Property Setter Injection** via JavaScript to force data entry into the DOM, bypassing modern front-end state-locking.
* **Defect Isolation:** Successfully identifies a functional "Last Name" input bug and an unresponsive "Continue" button in the `problem_user` profile.
* **Thread-Safe Reporting:** Integrated **Extent Reports 5** with automated, synchronized screenshot capturing for both PASS and FAIL states.
## 🛠️ Tech Stack
* **Language:** Java 17
* **Automation:** Selenium WebDriver 4.16.1
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Reporting:** Extent Reports
---
## 🐞 Bug Report: Functional Regression in 'Problem User' Profile
**Summary:** The application fails to process the 'Checkout' form when logged in as `problem_user`, despite valid data entry.
**Steps to Reproduce:**
1. Login with `problem_user`.
2. Add "Sauce Labs Backpack" to the cart.
3. Navigate to the Checkout page.
4. Enter First Name, Last Name, and Zip Code.
5. Click 'Continue'.
**Expected Result:** The application should navigate to `checkout-step-two.html` (Order Overview).
**Actual Result:** The application ignores the 'Last Name' input field (value remains empty in the DOM state) and the 'Continue' button becomes unresponsive.
**Automation Proof:**
The framework isolates this bug by using a **Native Property Setter Bypass**. Even when the value is forced into the input field via JavaScript, the application's internal state remains "Dirty," preventing navigation and triggering a `TimeoutException` in the automation suite.
---
## 🚀 How to Run
1. Clone the repository: `git clone https://github.com/AbhishekDhiman07/SauceDemo-DDT-E2E-Framework.git`
2. Execute the test suite: `mvn clean test`
## 📊 Test Status
* **Standard User:** ✅ **PASS**.
* **Problem User:** ❌ **FAIL (Verified Bug)**.

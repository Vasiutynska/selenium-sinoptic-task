# Selenium WebDriver - Weather Forecast Automation

This project automates the process of verifying weather forecast details on the website [Sinoptik.bg](https://sinoptik.bg) using Selenium WebDriver.

## Task Description

The automation task performs the following steps:

1. **Go to the Website**: Navigate to the website [https://sinoptik.bg](https://sinoptik.bg).
2. **Search for a City**: Search for your place of birth (e.g., Варна, Одеса) using the search field and select the correct city from the dropdown.
3. **Verify the Correct Forecast**: Ensure that the forecast displayed corresponds to the selected city.
4. **Verify 10-Day Forecast**: Go to the 10-day weather forecast section and verify:
    - **Correct Dates**: Ensure that the dates displayed match the expected dates (from today onwards).
    - **Correct Weekdays**: Verify that the weekdays displayed are correct and match the actual days of the week for the next 10 days in the selected language (Bulgarian).

## Project Details

- **Technology Used**: Selenium WebDriver with Java
- **Browser**: Google Chrome (via `ChromeDriver`)

### Key Methods

1. **`launchbrowser()`**: Opens the website and accepts the cookie consent if prompted.
2. **`getcity()`**: Searches for and selects the specified city from the dropdown.
3. **`checkcity()`**: Verifies that the forecast displayed matches the selected city.
4. **`checkDates()`**: Verifies that the 10-day forecast shows the correct dates.
5. **`checkWeekdays()`**: Verifies that the weekdays displayed in the forecast are correct.

## Prerequisites

- **Java**: Ensure that Java is installed on your system.
- **Selenium WebDriver**: Install Selenium WebDriver dependencies.
- **ChromeDriver**: Make sure you have the correct version of `ChromeDriver` installed to run tests on Google Chrome.

### Steps to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/Vasiutynska/selenium-sinoptic-task.git
    ```

2. Navigate to the project directory:
    ```bash
    cd selenium-sinoptic-task
    ```

3. Run the test script using your preferred IDE or from the command line (ensure that all dependencies and `ChromeDriver` are set up).

4. Observe the automation test in action on the website [Sinoptik.bg](https://sinoptik.bg).

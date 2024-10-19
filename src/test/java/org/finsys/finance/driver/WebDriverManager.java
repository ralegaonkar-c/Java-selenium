package org.finsys.finance.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Set the path to the ChromeDriver executable
        	System.setProperty("webdriver.chrome.driver", "E:\\chaitanya\\data-old\\mydata\\software\\chromedriver-win64\\chromedriver.exe");
            
            // Create ChromeOptions object (optional)
            ChromeOptions options = new ChromeOptions();
            // Add any options you want (e.g., headless, incognito, etc.)
            options.setBinary("E:\\chaitanya\\data-old\\mydata\\software\\chrome-win64\\chrome.exe");
            // Initialize the ChromeDriver
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set driver to null to allow a new instance to be created
        }
    }
}

//package org.finsys.finance.driver;
//
//public class WebDriverManager {
//
//}

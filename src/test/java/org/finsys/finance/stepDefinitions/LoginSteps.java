package org.finsys.finance.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.finsys.finance.hooks.Hooks;
import org.finsys.finance.driver.WebDriverManager;


import io.cucumber.java.en.*;

public class LoginSteps {

//    WebDriver driver = Hooks.driver;
    WebDriver driver = WebDriverManager.getDriver();


	@Given("User Launch the browser and enter URL {string}")
	public void user_launch_the_browser_and_enter_url(String url) {
		driver.get(url);
	}

    @When("User is on the Login Page")
    public void user_is_on_the_login_page() {
        String title = driver.getTitle();
        if(!title.equals("SBDC - Small Business Development Co.")) {
            throw new IllegalStateException("This is not the login page. The current page is: " + title);
        }
    }

    @And("enters valid username {string} in Username textbox")
    public void enters_valid_username_in_username_textbox(String user_name) {
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']")); // Update the locator as needed
        usernameField.sendKeys(user_name);
    }

    @And("valid password {string} in password textbox")
    public void valid_password_in_password_textbox(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']")); // Update the locator as needed
        passwordField.sendKeys(password);
    }

    @And("clicks on Login button")
    public void clicks_on_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//a//span[text()='Login']")); // Update the locator as needed
        loginButton.click();
    }

    @Then("Application should Login on the Home Page")
    public void application_should_perform_successful_login_operation() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         boolean titleChanged = wait.until(ExpectedConditions.titleContains("FinSys (SBDC) - eJagruti Educational Services"));

         if (!titleChanged) {
             throw new IllegalStateException("The page title did not change as expected after login.");
         }
         
         String homePageTitle = driver.getTitle();
         System.out.println("Logged in successfully. Home page title is: " + homePageTitle);
         
    }
}



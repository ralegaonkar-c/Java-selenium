package org.finsys.finance.stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.JavascriptExecutor;
import io.cucumber.java.en.*;

import java.time.Duration;
import java.util.List;
import static org.junit.Assert.*;

//import org.finsys.finance.hooks.Hooks;
import org.finsys.finance.driver.WebDriverManager;
import org.finsys.finance.gfl.ConfigReader;


public class ManageCompanySteps {

    WebDriver driver = WebDriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));    
    WebElement myframe ;
    
    ConfigReader configReader = new ConfigReader("xpathKV.conf");
    String objXpath;
    
    @Given("^User on home page after login.$")
    public void user_on_home_page_after_login() {
      System.out.println("User is logged in and on the Home Page.");
    }

    @When("^User clicks on Manage Company Node$")
    public void click_manage_company_sub_node() {
    	objXpath = configReader.getXPath("manageCompany"); 
//        WebElement manageCompanyNode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Manage Company']")));
        WebElement manageCompanyNode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objXpath)));
        manageCompanyNode.click();
    }

    @Then("^application will populate Manage Company Panel$")
    public void verify_manage_company_panel() {
    	objXpath = configReader.getXPath("manageCompanyFrame");
    	myframe = driver.findElement(By.xpath(objXpath));
//    	myframe = driver.findElement(By.xpath("//iframe[@id='actionid']"));
    	driver.switchTo().frame(myframe);
    	objXpath = configReader.getXPath("manageCompanyPanel");
    	WebElement manageCompanyPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//    	WebElement manageCompanyPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='panel-title' and text()='Company']")));
        if (!manageCompanyPanel.isDisplayed()) {
            throw new IllegalStateException("Manage Company Panel is not visible.");
        }
//        driver.switchTo().defaultContent();
    }
    
    @When("^User clicks on New Icon at the top left corner of displayed list$")
    public void click_new_icon() {
    	objXpath = configReader.getXPath("newRecord");
        WebElement newIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objXpath)));
//        WebElement newIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[text()='New']")));
        newIcon.click();
    }  

    @When("^enters Company Name as \"([^\"]*)\"$")
    public void enter_company_name(String companyName) {
    	objXpath = configReader.getXPath("companyName");
    	WebElement companyNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//    	WebElement companyNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']"))); 
        companyNameField.sendKeys(companyName);
    }

    @When("^Company Type as \"([^\"]*)\"$")
    public void enter_company_type(String companyType) {
    	objXpath = configReader.getXPath("companyType");
    	WebElement companyTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//    	WebElement companyTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='companytype']"))); 
        companyTypeField.sendKeys(companyType);
    }

    @When("^Company Subtype as \"([^\"]*)\"$")
    public void enter_company_subtype(String companySubtype) {
    	objXpath = configReader.getXPath("companySubtype");
    	WebElement companySubtypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//    	WebElement companySubtypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='subtype']"))); 
        companySubtypeField.sendKeys(companySubtype);
    }

    @When("^Address as \"([^\"]*)\"$")
    public void enter_address(String address) {
    	objXpath = configReader.getXPath("address");
    	WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//    	WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@class='textbox-text validatebox-text textbox-prompt']"))); 
        addressField.sendKeys(address);
    }

    @When("^Phone as \"([^\"]*)\"$")
    public void enter_phone(String phone) {
    	objXpath = configReader.getXPath("phone");
    	WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//    	WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='phone']//preceding-sibling::input"))); 
        phoneField.sendKeys(phone);
    }

    @When("^Email as \"([^\"]*)\"$")
    public void enter_email(String email) {
    	objXpath = configReader.getXPath("email");
    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//    	WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']"))); 
        emailField.sendKeys(email);
    }

    @When("^Pan Details as \"([^\"]*)\"$")
    public void enter_pan_details(String panDetails) {
    	objXpath = configReader.getXPath("panDetails");
    	WebElement panField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath))); 
//    	WebElement panField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='pan']"))); 
        panField.sendKeys(panDetails);
    }

    @When("^Tin Details as \"([^\"]*)\"$")
    public void enter_tin_details(String tinDetails) {
    	objXpath = configReader.getXPath("tinDetails");
    	WebElement tinField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath))); 
//    	WebElement tinField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='tin']"))); 
        tinField.sendKeys(tinDetails);
    }

    @When("^Mobile as \"([^\"]*)\"$")
    public void enter_mobile(String mobile) {
    	objXpath = configReader.getXPath("mobile");
    	WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath))); 
//    	WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='mobile']//preceding-sibling::input"))); 
        mobileField.sendKeys(mobile);
    }

    @When("^Web Site as \"([^\"]*)\"$")
    public void enter_website(String website) {
    	objXpath = configReader.getXPath("website");
    	WebElement websiteField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath))); 
//    	WebElement websiteField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='website']"))); 
        websiteField.sendKeys(website);
    }

    @When("^Country as \"([^\"]*)\"$")
    public void enter_country(String country) {
    	objXpath = configReader.getXPath("country");
    	WebElement countryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath))); 
//    	WebElement countryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='countryid']"))); 
        countryField.sendKeys(country);
    }

    @When("^State as \"([^\"]*)\"$")
    public void enter_state(String state) {
    	objXpath = configReader.getXPath("state");
    	WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath))); 
//    	WebElement stateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='state']"))); 
        stateField.sendKeys(state);
    }

    @When("^City Name as \"([^\"]*)\"$")
    public void enter_city_name(String cityName) {
    	objXpath = configReader.getXPath("cityName");
    	WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath))); 
//    	WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='city']"))); 
        cityField.sendKeys(cityName);
    }

    @When("^Total Employee as \"([^\"]*)\"$")
    public void enter_total_employee(String totalEmployee) {
    	objXpath = configReader.getXPath("totalEmployee");
        WebElement totalEmployeeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//        WebElement totalEmployeeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='totalemployee']/preceding-sibling::*[1]"))); 
        totalEmployeeField.sendKeys(totalEmployee);
    }

    @When("^User clicks on Save button$")
    public void click_save_button() {
    	objXpath = configReader.getXPath("save");
    	WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objXpath))); 
//    	WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a//span[text()='Save']"))); 
        saveButton.click();
    }

    
    @Then("^Application will populate Manage Company Panel with newly created company in company list.$")
    public void verify_new_company_created() {
    	objXpath = configReader.getXPath("testcomprow");

        // Locate the table body containing the rows
        WebElement myCompRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));
        
        // Find the row that contains "Mycomp"
//        objXpath = configReader.getXPath("companyRow");
//        WebElement myCompRow = tbody.findElement(By.xpath(objXpath));
//        WebElement myCompRow = tbody.findElement(By.xpath("//tr[td/div[contains(text(), 'Mycomp')]]"));
        
        System.out.println("Newly added data is \n" + myCompRow.getText());
    }
    
//    
//    @Then("^Application will populate Manage Company Panel with newly created company in company list.$")
//    public void verify_new_company_created() {
//    	objXpath = configReader.getXPath("tbody");
//
//        // Locate the table body containing the rows
//        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
////        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));
//        
//        // Find the row that contains "Mycomp"
//        objXpath = configReader.getXPath("companyRow");
//        WebElement myCompRow = tbody.findElement(By.xpath(objXpath));
////        WebElement myCompRow = tbody.findElement(By.xpath("//tr[td/div[contains(text(), 'Mycomp')]]"));
//        
//        System.out.println("Newly added data is \n" + myCompRow.getText());
//    }
    
//    @Then("User should see the following items under the Company Type dropdown:")
//    public void user_should_see_items_under_company_type_dropdown(List<String> expectedCompanyTypes) {
//    	objXpath = configReader.getXPath("companyType");
//    	WebElement companyTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(objXpath)));
//    	
////        WebElement companyTypeDropdown = driver.findElement(By.id("companyTypeDropdown")); // Adjust locator
//        companyTypeField.click();
//        
//        List<WebElement> dropdownOptions = driver.findElements(By.tagName("option")); // Adjust if needed
//        
//        for (String expected : expectedCompanyTypes) {
//            assertTrue(dropdownOptions.stream().anyMatch(option -> option.getText().equals(expected)));
//        }
//    }
}    

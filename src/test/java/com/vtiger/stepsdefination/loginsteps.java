package com.vtiger.stepsdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginsteps {

    public WebDriver driver = new ChromeDriver();


    @Given("user should be on login")
    public void user_should_be_on_login() {
        driver.get("http://localhost:100");
        driver.manage().window().maximize();

    }

    @When("user enters valid credentilas")
    public void user_enters_valid_credentilas() {
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.name("Login")).click();

    }

    @Then("user should navigated to home page")
    public void user_should_navigated_to_home_page() {
        driver.findElement(By.linkText("Home")).isDisplayed();


    }

    @Then("user can see logout link")
    public void user_can_see_logout_link() {

        driver.findElement(By.linkText("Logout")).isDisplayed();

    }

    @When("user enters the invalid credentilas")
    public void user_enters_the_invalid_credentilas() {

        driver.findElement(By.name("user_name")).sendKeys("admin12");
        driver.findElement(By.name("user_password")).sendKeys("admin12");
        driver.findElement(By.name("Login")).click();

    }

    @Then("user should be on same page")
    public void user_should_be_on_same_page() {

        driver.findElement(By.name("user_name")).isDisplayed();

    }

    @Then("user can see error message")
    public void user_can_see_error_message() {

        driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();

    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();

    }

    @When("user enters the invalid credentilas username as {string} and passwprd as {string}")
    public void user_enters_the_invalid_credentilas_username_as_and_passwprd_as(String uid, String pwd) throws InterruptedException {
        driver.findElement(By.name("user_name")).sendKeys(uid);
        driver.findElement(By.name("user_password")).sendKeys(pwd);
        Thread.sleep(2000);

        driver.findElement(By.name("Login")).click();
    }

    @When("user click on new lead link")
    public void user_click_on_new_lead_link() {

        driver.findElement(By.linkText("New Lead")).click();

    }

    @When("fill mandatory fields and click on save button")
    public void createlead_with_mandate() {

        driver.findElement(By.name("lastname")).sendKeys("Modi");
        driver.findElement(By.name("company")).sendKeys("BJP");
        driver.findElement(By.name("button")).click();

    }

    @Then("Lead should be created successfully")
    public void lead_should_be_created_successfully() {

        //driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[1]")).getText().equals("modi");
        driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[text()='modi']")).isDisplayed();
        driver.findElement(By.xpath("//td[text()='Company:']/following::td[text()='BJP']")).isDisplayed();

    }

    @When("fill mandatory fields lastname {string} and company {string} click on save button")
    public void fill_mandatory_fields_lastname_and_company_click_on_save_button(String lname, String comp) {
        driver.findElement(By.name("lastname")).sendKeys(lname);
        driver.findElement(By.name("company")).sendKeys(comp);
        driver.findElement(By.name("button")).click();

    }
    @Then("Lead should be created successfully with {string} and company {string}")
    public void lead_should_be_created_successfully_with_and_company(String lname, String comp) {

        driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[text()='"+lname+"']")).isDisplayed();
        driver.findElement(By.xpath("//td[text()='Company:']/following::td[text()='"+comp+"']")).isDisplayed();

    }


}








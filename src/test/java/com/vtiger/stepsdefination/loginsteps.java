package com.vtiger.stepsdefination;


import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ed;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v131.overlay.model.LineStyle;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;


public class loginsteps extends basesteps {


    @Given("user should be on login")
    public void user_should_be_on_login() throws IOException {
        readproperties();
        if (prop.getProperty("browser").equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (prop.getProperty("browser").equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (prop.getProperty("browser").equals("edge"))
        {
            driver = new EdgeDriver();
        }
        else
        {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--headless");
            driver = new ChromeDriver(option);
        }




        driver.get(prop.getProperty("appUrl"));
        driver.manage().window().maximize();

        int wait = Integer.parseInt(prop.getProperty("implicitwait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        ldp = new LeadPage(driver);

    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {

      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        //driver.findElement(By.name("user_name")).sendKeys("admin");
        //driver.findElement(By.name("user_password")).sendKeys("admin");
        //driver.findElement(By.name("Login")).click();
        lp.login("admin","admin");

    }

    @Then("user should navigated to home page")
    public void user_should_navigated_to_home_page() {
       // driver.findElement(By.linkText("Home")).isDisplayed();
        hp.verifyHome();
    }

    @Then("user can see logout link")
    public void user_can_see_logout_link() {

       // driver.findElement(By.linkText("Logout")).isDisplayed();
        hp.verifyLogout();

    }

    @When("user enters the invalid credentilas")
    public void user_enters_the_invalid_credentilas() {

        /*driver.findElement(By.name("user_name")).sendKeys("admin12");
        driver.findElement(By.name("user_password")).sendKeys("admin12");
        driver.findElement(By.name("Login")).click();*/
        lp.login(prop.getProperty("userid"),prop.getProperty("password"));

    }

    @Then("user should be on same page")
    public void user_should_be_on_same_page() {

       // driver.findElement(By.name("user_name")).isDisplayed();
        lp.sverifyUsername();

    }

    @Then("user can see error message")
    public void user_can_see_error_message() {

        //driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();
        lp.verifyerroemessage();
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();

    }

    @When("user enters the invalid credentilas username as {string} and passwprd as {string}")
    public void user_enters_the_invalid_credentilas_username_as_and_passwprd_as(String uid, String pwd) throws InterruptedException {
        /*driver.findElement(By.name("user_name")).sendKeys(uid);
        driver.findElement(By.name("user_password")).sendKeys(pwd);
        Thread.sleep(2000);
        driver.findElement(By.name("Login")).click();*/

        lp.login(uid,pwd);
    }

}








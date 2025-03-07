package com.vtiger.stepsdefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

public class leadsteps extends Basesteps {


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

        driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[text()='" + lname + "']")).isDisplayed();
        driver.findElement(By.xpath("//td[text()='Company:']/following::td[text()='" + comp + "']")).isDisplayed();

    }

    @When("user create the lead data with {string} and  {string} and verify sucessful lead creation")
    public void user_create_the_lead_data_with_and_and_verify_sucessful_lead_creation(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> lst = dataTable.asLists();
        for (int i = 0; i < lst.size(); i++) {
            driver.findElement(By.linkText("New Lead")).click();
            driver.findElement(By.name("lastname")).sendKeys(lst.get(i).get(0));
            driver.findElement(By.name("company")).sendKeys(lst.get(i).get(1));
            driver.findElement(By.name("button")).click();
            driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[text()='" + lst.get(i).get(0) + "']")).isDisplayed();
            driver.findElement(By.xpath("//td[text()='Company:']/following::td[text()='" + lst.get(i).get(1) + "']")).isDisplayed();


        }

    }
}





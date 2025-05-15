package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;

public class LeadPage extends HeaderPage {

    public WebDriver driver;

    public LeadPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "lastname")
    WebElement lastname;

    @FindBy(name = "company")
    WebElement company;

    @FindBy(name = "button")
    WebElement save;

    public void  Createlead(String lname,String comp)
    {
        setlastname(lname);
        setCompany(comp);
        clicksave();

    }


    public void setlastname(String lname)
    {
      //  lastname.sendKeys(lname);
        setInput(lastname,lname);

    }

    public void setCompany(String comp)
    {
        //company.sendKeys(comp);

        setInput(company,comp);
    }

    public void clicksave()
    {
        //save.click();

        ClickElement(save);

    }

    public void validatelead(String lname,String comp)
    {



        checkdisplay(driver.findElement(By.xpath("//td[text()='Last Name:']/following::td[text()='" + lname + "']")));
        checkdisplay(driver.findElement(By.xpath("//td[text()='Company:']/following::td[text()='" + comp + "']")));
    }









}

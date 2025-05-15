package com.vtiger.pages;

import com.vtiger.utilities.commonmethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends commonmethods {
    public WebDriver driver;

    public HeaderPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Home")
    WebElement lnk_home;

    @FindBy(linkText = "Logout")
    WebElement lnk_logout;

    @FindBy(linkText = "New Lead")
    WebElement lnk_NewLead;

    @FindBy(linkText = "Leads")
    WebElement lnk_Leads;

    public void verifyHome()
    {
        //lnk_home.isDisplayed();

        checkdisplay(lnk_home);
    }

    public void verifyLogout()
    {
        //lnk_logout.isDisplayed();

        checkdisplay(lnk_logout);
    }

    public void clickLogout()
    {
        //lnk_logout.click();
        ClickElement(lnk_logout);
    }
    public void clickNewLead()
    {
        //lnk_NewLead.click();
        ClickElement(lnk_NewLead);
    }
    public void clickLeads()
    {
        //lnk_Leads.click();

        ClickElement(lnk_Leads);
    }

}

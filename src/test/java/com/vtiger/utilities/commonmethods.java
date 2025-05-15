package com.vtiger.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class commonmethods {

    private WebDriver driver;
    public WebDriverWait wait;

    public commonmethods(WebDriver driver)
    {
        this.driver = driver;
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setInput(WebElement elm, String val)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(val);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void ClickElement (WebElement elm)
    {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void checkdisplay (WebElement elm)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void selecttext(WebElement elm, String txt)
    {
        try {
            wait.until(ExpectedConditions.elementToBeSelected(elm));
            Select sel = new Select(elm);
            sel.selectByVisibleText(txt);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

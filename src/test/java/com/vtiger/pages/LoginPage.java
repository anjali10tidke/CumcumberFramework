package com.vtiger.pages;

import com.vtiger.utilities.commonmethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends commonmethods {

    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "user_name")
    WebElement userid;

    @FindBy(xpath = "//input[@name='user_password']")
            WebElement userpassword;

    @FindBy(xpath = "//input[@name='Login']")
    WebElement login;

    @FindBy (name = "login_theme")
            WebElement them;

    @FindBy(xpath = "//*contains(test(),'You must specify a valid userid and password.'")
    WebElement errormsg;


    /*String user_id = "//input[@name='user_name']";

    By userid = By.name("user_name");
    By userpassword = By.name("user_password");
    By login = By.name("Login");
    By them = By.name("login_theme");*/


    public void  login(String uid,String pwd)
    {


        setusername(uid);
        setupassword(pwd);
        clicklogin();

    }

    public void setusername(String uid)
    {
       //userid.sendKeys(uid);

       setInput(userid,uid);

    }
    public void sverifyUsername()
    {
        //userid.isDisplayed();

        checkdisplay(userid);

    }
    public void setupassword(String pwd)
    {
        //userpassword.sendKeys(pwd);

        setInput(userpassword,pwd);

    }
    public void clicklogin()
    {
        //login.click();

        ClickElement(login);

    }

    public void selecttheme(String theme)
    {
      //them.sendKeys(theme);
        selecttext(them,theme);

    }

    public void verifyerroemessage()
    {
        //errormsg.isDisplayed();

        checkdisplay(errormsg);
    }

    public void  login(String uid,String pwd,String theme)
    {
        setusername(uid);
        setupassword(pwd);
        clicklogin();
        selecttheme(theme);

    }
}




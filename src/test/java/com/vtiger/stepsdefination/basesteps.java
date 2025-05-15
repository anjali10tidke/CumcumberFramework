package com.vtiger.stepsdefination;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class basesteps
{
    public static WebDriver driver;
    public static LoginPage lp;
    public static HomePage hp;
    public static LeadPage ldp;

    public static  Properties prop;

    public void readproperties() throws IOException {
         prop = new Properties();

        FileInputStream fis = new FileInputStream( System.getProperty("user.dir")+"/src/test/resources/Configuration/config.properties");
        prop.load(fis);
    }
}

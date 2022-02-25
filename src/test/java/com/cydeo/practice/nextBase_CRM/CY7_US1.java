package com.cydeo.practice.nextBase_CRM;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY7_US1 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void verify_title() {
        // go to https://login1.nextbasecrm.com/ page
        driver.get("https://login1.nextbasecrm.com/");

//        1. The login page title should be “Authorization.”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Authorization";

        Assert.assertEquals(actualTitle, expectedTitle);

    }








}
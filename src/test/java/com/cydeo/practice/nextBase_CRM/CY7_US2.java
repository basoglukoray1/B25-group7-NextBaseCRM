package com.cydeo.practice.nextBase_CRM;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY7_US2 {
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
    public void remember_checkbox_test(){
        // go to https://login1.nextbasecrm.com/ page
        driver.get("https://login1.nextbasecrm.com/");

        WebElement rememberMeCheckBox= driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));

        Assert.assertTrue(rememberMeCheckBox.isDisplayed());
    }

    @Test
    public void rememberMe_text_verify(){
        // go to https://login1.nextbasecrm.com/ page
        driver.get("https://login1.nextbasecrm.com/");
        WebElement rememberMeText= driver.findElement(By.xpath("//*[text()='Remember me on this computer']"));

        Assert.assertTrue(rememberMeText.isDisplayed());

    }






}
//                1. There should be a Checkbox label displayed to enable users to save their user credentials on computers.
//                2. “Remember me on this computer” should be displayed on the left side of the checkbox label.
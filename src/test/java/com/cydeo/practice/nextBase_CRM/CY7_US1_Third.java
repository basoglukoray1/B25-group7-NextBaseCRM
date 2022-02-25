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

public class CY7_US1_Third {
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
    public void test_incorrect_credential_text(){
        driver.get("https://login1.nextbasecrm.com/");
        //  3. “Incorrect username or password” should be displayed when a user enters the wrong username or password.

        //Enter a incorrect username
        WebElement usernameInput = driver.findElement(By.xpath("//*[@name='USER_LOGIN']"));
        usernameInput.sendKeys("abc");

        //Enter a incorrect password
        WebElement passwordInput = driver.findElement(By.xpath("//*[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("abc");

        //click to Log In button
        WebElement loginButton=driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

        //verify the incorrect message if username or password is incorrect
        WebElement incorrectText=driver.findElement(By.xpath("//div[@class='errortext']"));

        Assert.assertTrue(incorrectText.isDisplayed());

    }





}

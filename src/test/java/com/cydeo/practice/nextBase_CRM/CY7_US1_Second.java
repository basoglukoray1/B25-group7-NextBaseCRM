package com.cydeo.practice.nextBase_CRM;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY7_US1_Second {
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
    public void login_test() {
// go to https://login1.nextbasecrm.com/ page
        driver.get("https://login1.nextbasecrm.com/");

    //        2. The user should go to the homepage after login in successfully.
    //Enter a valid username
    WebElement usernameInput = driver.findElement(By.xpath("//*[@name='USER_LOGIN']"));
        usernameInput.sendKeys("marketing1@cydeo.com");

    //Enter a valid password
    WebElement passwordInput = driver.findElement(By.xpath("//*[@name='USER_PASSWORD']"));
        passwordInput.sendKeys("UserUser");

    //click to Log In button
    WebElement loginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginButton.click();

}



}

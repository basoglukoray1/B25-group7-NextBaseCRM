package com.cydeo.practice.nextBase_CRM;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY7_3_Second {

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
    public void log_out_test() {
        // go to https://login1.nextbasecrm.com/ page
        driver.get("https://login1.nextbasecrm.com/");

        //enter valid username credential
        WebElement username=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("marketing1@cydeo.com");

        //enter valid password credential

        WebElement password=driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        //click log in button
        WebElement loginButton= driver.findElement(By.xpath("//input[@value='Log In']"));

        loginButton.click();

        //click on user profile function
        WebElement userProfile= driver.findElement(By.xpath("//div[@class='user-block']"));
        userProfile.click();

        //check if Log out button is displayed
        WebElement logoutButton=driver.findElement(By.xpath("//*[text()='Log out']"));

        System.out.println(logoutButton.isDisplayed());

        //click to log out button and go back to Log In page

        BrowserUtils.sleep(2);

        logoutButton.click();




    }
}

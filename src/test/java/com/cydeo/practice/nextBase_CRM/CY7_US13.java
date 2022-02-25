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

public class CY7_US13 {

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
    public void text_create_appreciation(){
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

        //click MORE button to see appreciation option
        WebElement moreButton=driver.findElement(By.xpath("//*[@class='feed-add-post-form-link-text']"));
        moreButton.click();

        //click Appreciation option
        WebElement appreciationButton= driver.findElement(By.xpath("//*[text()='Appreciation']"));
        appreciationButton.click();

        //click message Iframe
       driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));

       //enter some content
        WebElement content= driver.findElement(By.xpath("//body[@contenteditable='true']"));

       content.sendKeys("Hello B25 Test 2");

       driver.switchTo().parentFrame();

       //click send button
        WebElement sendButton=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        //make sure that user can see the message on the screen board
        WebElement messageShowing=driver.findElement(By.xpath("//*[@id='blog_post_body_215']"));

        System.out.println("messageShowing.isDisplayed() = " + messageShowing.isDisplayed());

        //

    }
    @Test
    public void test_appreciation_withNoContent(){
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

        //click MORE button to see appreciation option
        WebElement moreButton=driver.findElement(By.xpath("//*[@class='feed-add-post-form-link-text']"));
        moreButton.click();

        //click Appreciation option
        WebElement appreciationButton= driver.findElement(By.xpath("//*[text()='Appreciation']"));
        appreciationButton.click();

        //click message Iframe
        driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[1]")));

        //enter some content
        WebElement content= driver.findElement(By.xpath("//body[@contenteditable='true']"));

        content.sendKeys("");

        driver.switchTo().parentFrame();

        //click send button
        WebElement sendButton=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();

        //verify if The message title is not specified is displayed
        WebElement errorText= driver.findElement(By.xpath("//*[text()='The message title is not specified']"));

        Assert.assertTrue(errorText.isDisplayed());

    }

//        1. Users should be able to write messages in and send appreciation by clicking the SEND button.
//        2. When users attempt to make appreciation without a message,
//    there should be a working message “The message title is not specified.”






}

package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {
    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void multiple_windows_test(){

        //Storing the main page's window handle as string is good practice for future re-usable purposes
        String mainHandle= driver.getWindowHandle();

        System.out.println(mainHandle);
//        4. Assert: Title is “Windows”

        String expectedTitle="Windows";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);


//        5. Click to: “Click Here” link
        WebElement clickHereLink= driver.findElement(By.linkText("Click Here"));

        clickHereLink.click();


//        6. Switch to new Window.
        for (String each: driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }




//        7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle= driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitleAfterClick);

        actualTitle= driver.getTitle();

        System.out.println("Title after click: "+actualTitle);


    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }




}

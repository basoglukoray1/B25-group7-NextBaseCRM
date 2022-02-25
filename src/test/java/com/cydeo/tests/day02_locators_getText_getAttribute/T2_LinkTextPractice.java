package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {
    public static void main(String[] args) {
//        TC #3: Back and forth navigation
//        1- Open a chrome browser
             WebDriverManager.chromedriver().setup();
             WebDriver driver=new ChromeDriver();
             driver.manage().window().maximize();


//        2- Go to: https://practice.cydeo.com/
            driver.get("https://practice.cydeo.com/");

//        3- Click to A/B Testing from top of the list.
            //Thread.sleep(300); we can put it here also
            //driver.findElement(By.linkText("A/B Testing")).click();
            WebElement abTestLink= driver.findElement(By.linkText("A/B Testing"));
            abTestLink.click(); // gurhan said we should prefer like this instead of end of line 24


//        4- Verify title is:
//        Expected: No A/B Test
        String expectedTitle="No A/B Test";
        String actualTitle= driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }


//        5- Go back to home page by using the .back();
            driver. navigate().back();

//        6- Verify title equals:
//        Expected: Practice
        expectedTitle="Practice";
        actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
    }
}

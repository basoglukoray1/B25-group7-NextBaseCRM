package com.cydeo.tests.day1_selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.yahoo.com");

        Thread.sleep(3000);

        String expectedTitle="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos";

        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is expected, verification PASSED!");
        }else{
            System.out.println("Title is not expected. Verification FAILED!");
        }


        driver.close();


    }
}

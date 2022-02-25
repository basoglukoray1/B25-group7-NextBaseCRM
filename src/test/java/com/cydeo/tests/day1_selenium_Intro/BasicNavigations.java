package com.cydeo.tests.day1_selenium_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {


        //1- Set up the browser driver
        WebDriverManager.chromedriver().setup();

        //2- Create instance of the Selenium WebDriver
        //this ius the line that opening an empty browser
        WebDriver driver=new ChromeDriver();

        //this line will maximize the browser size
        driver.manage().window().maximize();

        //3- Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        String currentURL =  driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //Stop code exewcution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().back();
        //Stop code exewcution for 3 seconds
        Thread.sleep(3000);

        //use selenium to navigate back
        driver.navigate().forward();

        //Stop code exewcution for 3 seconds
        Thread.sleep(3000);

        //use seleinium to navigate refresh
        driver.navigate().refresh();

        // use navigate to method
        driver.navigate().to("https://www.google.com");

        //get the title of the page
        driver.getTitle();

        currentTitle= driver.getTitle();


        //System.out.println("driver = " + driver.getTitle());

        System.out.println("driver.getTitle() = " + currentTitle);

        //Get the current URL using selenium
        currentURL=driver.getCurrentUrl();

        System.out.println(currentURL);

        //this will close the currentl opened window
        driver.close();


        //this will cloase all of the opened windwos
        driver.quit();






    }








}

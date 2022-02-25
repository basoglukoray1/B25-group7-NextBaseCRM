package com.cydeo.avengersHours;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01 {
    public static void main(String[] args) {

//        TC:1 As a user I should be able to see Home is displayed

        //1-open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");


        //3-verify Home is displayed
        WebElement home=driver.findElement(By.xpath("//a[@href='https://vytrack.com/']"));

        System.out.println("home.isDisplayed() = " + home.isDisplayed());


    }
}

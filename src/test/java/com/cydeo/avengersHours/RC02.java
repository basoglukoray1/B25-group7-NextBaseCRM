package com.cydeo.avengersHours;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RC02 {
    public static void main(String[] args) {


       // TC:2 As a user I should be able to see About is displayed

        //1-open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");


        //3-verify About us is displayed
        WebElement about= driver.findElement(By.xpath("//a[@href='https://vytrack.com/about-us/']"));

        about.getText();

        if (about.isDisplayed()){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }





    }
}

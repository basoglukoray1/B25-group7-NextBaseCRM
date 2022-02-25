package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_cont {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //Locate name='sports' radio buttons and store them in a List of  Web Element

        
        clickAndVerifyRadioButton(driver, "sport", "football");


    }

    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) throws InterruptedException {
        List<WebElement> RadioButtons = driver.findElements(By.name(nameAttribute));
        //Loop through the List of WebElement and select matching result "hockey"
        for (WebElement each : RadioButtons) {
            String eachId= each.getAttribute("id");


            if (eachId.equals(idValue)) {
                Thread.sleep(2000);

                each.click();
                System.out.println( eachId +" is selected : " + each.isSelected());
                break;

            }
        }


    }








}

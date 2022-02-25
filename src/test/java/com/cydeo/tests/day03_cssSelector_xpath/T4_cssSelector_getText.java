package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {

//        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
//        3- Verify “Reset password” button text is as expected:
//        Expected: Reset password

        //locating reset passwortd button using class attribute and its value
        WebElement resetPasswordButton= driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectedResetPasswordButtonText= "Reset password";
        String actualResetPasswordButtonText=resetPasswordButton.getText();

        if (actualResetPasswordButtonText.equals(expectedResetPasswordButtonText)){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }
        //*[@id="login-popup"]/form/div[2]/input
//
//        PS: Inspect and decide which locator you should be using to locate web
//        elements
//        PS2: Pay attention to where to get the text of this button from














    }

}

package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class className {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //make browser fullscreen,max
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

         WebElement homeLink= driver.findElement(By.className("nav-link"));

         homeLink.click();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

         driver.findElement(By.className("h3")).getText();
         //print multiple buttons header
        System.out.println( driver.findElement(By.className("h3")).getText());




    }

}

package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //make browser fullscreen,max
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullNameInput = driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike smith with TagName");

        WebElement emailBox = driver.findElement(By.name("email"));
       emailBox.sendKeys("mike@smith.com");
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(4000);
        //close browser
        driver.quit();









    }
}

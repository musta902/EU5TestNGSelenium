package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class exercises {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.demoqa.com/buttons");

        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));

        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).perform();






    }
}
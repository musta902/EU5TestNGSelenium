package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupAndAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void test1 () {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.manage().window().maximize();

        //click the confirm button
        driver.findElement(By.xpath("//span[.='Confirm']")).click();

        //click no button
        driver.findElement(By.xpath("//span[.='No']")).click();
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.manage().window().maximize();

        //click Click for JS Alert button
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        //switch to JS alert pop up
        Alert alert = driver.switchTo().alert();

        Thread.sleep(2000);
        alert.accept();

        //click for JS Confirm
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        alert.dismiss();

        //click for JS Promt
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        //sendkeys to the js promt
        alert.sendKeys("Mike smith");
        //click ok
        alert.accept();




    }

}
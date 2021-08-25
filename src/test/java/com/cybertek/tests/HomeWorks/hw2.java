package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class hw2 {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");


        WebElement a= driver.findElement(By.xpath("//li/a[@class='nav-link']"));

        System.out.println(a.getText());
        a.click();
        driver.navigate().back();

       driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");


        WebElement b= driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        System.out.println(b.getText());


        driver.get("http://practice.cybertekschool.com/forgot_password");


        WebElement c= driver.findElement(By.xpath("//label[text()='E-mail']"));

        System.out.println(c.getText());


        driver.get("http://practice.cybertekschool.com/forgot_password");


        WebElement d= driver.findElement(By.xpath("//input[@type='text']"));////label[@for='email']/../input also usable this

        System.out.println(d.getText());



        driver.get("http://practice.cybertekschool.com/forgot_password");


        WebElement e= driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));

        System.out.println(e.getText());

        e.getText();































    }
}

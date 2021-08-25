package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClosAndQuit {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");



        Thread.sleep( 3000);
        //close current tab
        //driver.close();
        driver.close();

        // giving new browser tab(if we not give this new object that gives error because the tabs already closed )
        driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep( 5000);
        //all tabs closes
        driver.quit();











    }
}

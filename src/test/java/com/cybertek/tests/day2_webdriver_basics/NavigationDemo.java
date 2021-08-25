package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com");
        driver.navigate().to("https://www.facebook.com");

        //wait three seconds move on
        Thread.sleep( 3000);


        //goes back to previous again
        driver.navigate().back();


        Thread.sleep( 2000);

        // goes back to back
        driver.navigate().back();

        //refresh the webpage
        driver.navigate().refresh();

















    }


}

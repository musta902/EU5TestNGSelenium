package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();//just empty browser opening if we are running just this

        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertekschool.com");// we can use it also  to firefox and others


    }
}

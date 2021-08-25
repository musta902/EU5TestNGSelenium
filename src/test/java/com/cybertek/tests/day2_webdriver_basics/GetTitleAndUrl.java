package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

        //getting title with selenium
        //shortcut for creating variable
        //option or alt + enter enter
        // getTitle()=that get from page source code title
        String title = driver.getTitle();
        //soutv directly print shortcut
        System.out.println("title = " + title);


        //getCurrentUrl()= is get the url from browse
       String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //.getPageSource()=gets the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);



    }
}

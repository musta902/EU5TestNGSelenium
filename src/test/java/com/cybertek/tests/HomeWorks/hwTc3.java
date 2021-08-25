package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hwTc3 {
    public static void main(String[] args) {
      //Go to wikipedia.org (Links to an external site.)
       WebDriver driver=WebDriverFactory.getDriver("chrome");
       driver.get("https://www.wikipedia.org");

       //enter search term `selenium webdriver`
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchInput']"));
        searchBox.sendKeys("selenium webdriver");

        //click on search button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //click on search result `Selenium (software)`
        driver.findElement(By.cssSelector("a[href$='Selenium_(software)']")).click();

        //verify url ends with `Selenium_(software)'
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        String expectedUrl = "Selenium_(software)";
        if(currentUrl.endsWith(expectedUrl)){
            System.out.println("PASS");


        }else{
            System.out.println("FAIL");
        }





        driver.quit();
    }
}

//Test case 3
//Go to wikipedia.org (Links to an external site.)
//enter search term `selenium webdriver`
//click on search button
//click on search result `Selenium (software)`
//verify url ends with `Selenium_(software)'
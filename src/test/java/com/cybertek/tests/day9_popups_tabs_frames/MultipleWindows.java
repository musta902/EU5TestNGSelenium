package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void SwitchWindowstest(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Title before new window: " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        //get title
        System.out.println("Title after new window: " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());


        String currentWindowHandle = driver.getWindowHandle();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {

            if(!currentWindowHandle.equals(currentWindowHandle)){
                driver.switchTo().window(windowHandle) ;
            }

        }
        System.out.println("Title after switch new window " + driver.getTitle());

    }
    @Test
    public void moreThan2Windows(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("Title before new window: " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();

        //get title
        System.out.println("Before switch: " + driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();
        // loop through each window
        for (String windowHandle : windowHandles) {
            //one by one change it
            driver.switchTo().window(windowHandle);
            //whenever your title is equals to your expected window title (New Window)
            if(driver.getTitle().equals("New Window")){
                //stop on that window
                break;

            }
        }

    }


}
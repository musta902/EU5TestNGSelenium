package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskFinish {

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

        public void test1(){
            // open chrome browser and navigate the webpage which is "MEETSKY"
            driver.get("http://qa.meetsky.net/index.php/login?clear=1");
            // find the login box and input the correct username
            WebElement loginPage = driver.findElement(By.id("user"));
            loginPage.click();
            loginPage.sendKeys("Employee1");
            //find the passwordBox and login  valid password
            WebElement passwordBox = driver.findElement(By.id("password"));
            passwordBox.click();
            passwordBox.sendKeys("Employee123");
            //click the login button
            WebElement loginButton = driver.findElement(By.id("submit-form"));
            loginButton.click();


            //click on the talk button
            driver.get("http://qa.meetsky.net/index.php/apps/spreed/");
            WebElement talkButton = driver.findElement(By.cssSelector("#appmenu > li:nth-child(4) > a > svg > image"));
             talkButton.click();

          //click on the menu button
            driver.get("http://qa.meetsky.net/index.php/apps/spreed/");
            WebElement menuButton = driver.findElement(By.cssSelector("#app-navigation-vue > a"));
            menuButton.click();


            //verify displayed the users or conversations viewBox
           // driver.get("http://qa.meetsky.net/index.php/apps/spreed/");
          //  WebElement viewBox = driver.findElement(By.cssSelector("#app-navigation-vue > div.new-conversation > form > input"));
          //  viewBox.click();
            String expectedTitle="Talk - Meetsky - QA";
            String actualTitle= driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle,"verify that the viewBox is successfully opened");

            if(expectedTitle.equals(actualTitle)) {
                System.out.println("PASS");
            } else{
                System.out.println("FAIL");

            }




    }












    }








       // TASK TO FINISH
       //open the browser
        //go to MEETSKY page
        //automate log in
        //click on your user story menu/tab
        //verify that you successfully see your page
       // 1.  Clone the project
        //2. Create your own branch
       // 3. Create your own class
         //4. Commit and push to GItHUb
        //5. Create a pull request
       // 6. Add a reviewer
       // 7. Delete your branch
       // 8. When you start a new work you need to update the project first, then create a new branch continue your work

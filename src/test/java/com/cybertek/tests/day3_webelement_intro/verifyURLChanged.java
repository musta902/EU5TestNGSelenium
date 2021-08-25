package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLChanged {
    public static void main(String[] args) throws InterruptedException {


     /* Verify URL changed
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        click on Retrieve password
        verify that url changed to http://practice.cybertekschool.com/email_sent
    */
    //open the browser

     WebDriver driver= WebDriverFactory.getDriver("chrome");

    //go to http://practice.cybertekschool.com/forgot_password Links to an external site.

     driver.get("http://practice.cybertekschool.com/forgot_password" );

    // enter any email
        WebElement emailInputBox=driver.findElement(By.name("email"));
         emailInputBox.sendKeys("mike@smith.com");

        //click on Retrieve password

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();
        //Thread.sleep(3000); if it is did not match you can use thread for time
        //verify that url changed to http://practice.cybertekschool.com/email_sent
        //create expectedURL

        String expectedURL="http://practice.cybertekschool.com/email_sent";

        //saving actualURL from browser after we enter any email and click retrieve password button
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL" );
            System.out.println("expectedUrl = " + expectedURL);
            System.out.println("actualUrl = " + actualURL);
        }
        //close your browser
        driver.quit();











}
}
package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class verifyURLnotChanged {
    public static void main(String[] args) {
        /*Verify URL not changed
	    -open chrome browser
	    -go to http://practice.cybertekschool.com/forgot_password Links to an external site.
	    -click on Retrieve password
	    -verify that url did not change
	*/
         // open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

          //go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        driver.get(" http://practice.cybertekschool.com/forgot_password ");


        //save expected URL before clicking button.
        String expectedURL = driver.getCurrentUrl();

        //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        //save actual url after the clicking button
        String actualURL = driver.getCurrentUrl();

        // verify that url did not  changed

        if (expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL" );
        }
        //close your browser
        driver.quit();




    }


}

package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {


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
            driver.get("http://practice.cybertekschool.com/multiple_buttons");
            // Assert.assertFalse(false);
            //driver.quit();

            //save our web elements inside list
            List<WebElement> buttons= driver.findElements(By.tagName("button"));
            System.out.println("buttons.size() = " + buttons.size());
            //verify button size
            Assert.assertEquals(buttons.size(),6,"verify buttons size");

            // iter + enter to get each loop with shortcut
            for (WebElement button : buttons) {
                //  System.out.println("button.getText() = " + button.getText());

                System.out.println("button.isDisplayed() = " + button.isDisplayed());
                Assert.assertTrue(button.isDisplayed(),"verify buttons are displayed");

            }
            // click second button
            buttons.get(1).click();


        }
        @Test

        public void test2(){
            driver.get("http://practice.cybertekschool.com/multiple_buttons");
            //regular findElement method will throw NSE if locator does not mach
            //driver.findElement(By.tagName("btfddf")

            //passing locator which does not exist,it will not throw NoSuchElement
            //ALT+Enter or OPTION+enter then more enter for the shortcut
            List<WebElement> buttons= driver.findElements(By.tagName("butt"));//wrong locator is empty size printout
            System.out.println("buttons.size() = " + buttons.size());



        }

    }


package com.cybertek.tests.day8_types_of_elements_2;


import com.cybertek.utilities.WebDriverFactory;
import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.Locate your dropdown just lie ant oher webelement with unique locator
        WebElement dropdownElement= driver.findElement(By.xpath("//select[@id='state']"));

        // 2.create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        // get options --> returns all the available options from the dropdown
        List<WebElement> options = stateDropdown.getOptions();

        //print size of the options
        System.out.println("options.size() = " + options.size());

        // print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }
    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.Locate your dropdown just lie ant oher webelement with unique locator
        WebElement dropdownElement= driver.findElement(By.xpath("//select[@id='state']"));

        // 2.create select object by passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //verify that first selection is Select a state
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        // HOW TO SELECT OPTIONS FROM DROPDOWN
        //1.SELECT VISIBLE TEXT
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginiaa");
        expectedOption="Virginia";
        actualOption=stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,expectedOption,"verify first selected ");

        // 2.SELECT USING INDEX

        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify first selection");
        //3.SELECT BY VALUE
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");
        expectedOption = "Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,actualOption,"verify the  first selection");




    }

}

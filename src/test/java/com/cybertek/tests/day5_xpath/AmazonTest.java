package com.cybertek.tests.day5_xpath;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://amazon.com");

        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));


        searchBox.sendKeys("java");

       //click search box

      driver.findElement(By.xpath("//input[@value='Go']")).click();

      WebElement result= driver.findElement(By.xpath("//span[contains(text(),'results for')]"));// results for part static part so we are using that

        String resultText=result.getText();

        System.out.println("resultText = " + resultText);

        String expectedResult = "1-48 of over 4,000 results for";
        String actualResult=result.getText();

        if (expectedResult.equals(result.getText())) {
            System.out.println("PASS");

        } else{
            System.out.println("FAIL");
        }


















    }




}

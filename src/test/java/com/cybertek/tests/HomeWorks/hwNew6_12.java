package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hwNew6_12 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void test6() {
        //Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com/");

        // Step 2. Copy and save email as a string.
        String text = driver.findElement(By.xpath("//div/span[@class='animace']")).getText();
        System.out.println("text = " + text);


        // Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//li/a[.='Sign Up For Mailing List']")).click();


        //Step 5. Enter any valid name.
        driver.findElement(By.xpath("(//div/input)[1]")).sendKeys("Mike Smith");
        // step6 . Enter email step 2
        driver.findElement(By.xpath("(//div/input)[2]")).sendKeys(text);

        // Step 7. Click Sign Up
        driver.findElement(By.tagName("button")).click();
        // Step 8. Verify that following message is displayed:“Thank you for signing up. Click the button below to
        //        return to the home

    }

    @Test
    public void test7() throws InterruptedException {

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement button = driver.findElement(By.xpath("//li/a[.='File Upload']"));
        button.click();

        //locating choose file button
        WebElement file = driver.findElement(By.name("file"));
        // file.click();


        //sending file
        file.sendKeys("C:\\Users\\Eigenaar\\Desktop\\file.txt");

        //clicking upload button
        driver.findElement(By.id("file-submit")).click();
        //getting the file name from browser
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("actualFileName = " + actualFileName);
        //verify file name is file.txt
        Assert.assertEquals(actualFileName, "file.txt");


        //verify file uploaded
        String text2 = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
        System.out.println("text2 = " + text2);
        Assert.assertEquals(text2, "File Uploaded!", "verify the uploaded message is displayed");

        //Step 6. Verify that uploaded file name is displayed.
        String text1 = driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("text1 = " + text1);
        Assert.assertEquals(text1, "file.txt", "verify the uploaded message is displayed");


    }

    @Test
    public void test8() {
        //Step 1. Go to “https://practicecybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        // Step 2. And click on “Autocomplete”.
        driver.findElement(By.xpath("//li/a[.='Autocomplete']")).click();

        // Step 3. Enter “United States of America” into  country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

       // Step 4. Verify that following message is displayed:
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();


        WebElement confirmText = driver.findElement(By.id("result"));

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(confirmText));
        String confirmText1 = confirmText.getText();
        System.out.println("confirmText1 = " + confirmText1);

        Assert.assertEquals(confirmText1,"You selected: United States of America","verify the confirm message is dosplayed");

    }
    @Test
    public void test9() {


    }



}
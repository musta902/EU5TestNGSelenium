package com.cybertek.tests.HomeWorks;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hwNew1_5 {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Step 1..Navigate URL
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//ul/li/a[.='Registration Form']"));
        registrationForm.click();
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test

    public void testcase1(){
//        //Step 1..Navigate URL
//       driver.get("https://practice-cybertekschool.herokuapp.com/");
//
//        //Step 2. Click on “Registration Form”
//       WebElement registrationForm = driver.findElement(By.xpath("//ul/li/a[.='Registration Form']"));
//       registrationForm.click();

        //Step 3. Enter “wrong_dob” into date of birth inputBox
       WebElement birthDayBox =driver.findElement(By.xpath("(//input[@class='form-control'])[7]"));
       birthDayBox.click();
       birthDayBox.sendKeys("35/08/2010");

       //Step 4. Verify that warning message is displayed:“The date of birth is not valid”

        WebElement invalidMessage =driver.findElement(By.xpath("//small[.='The date of birth is not valid']"));

        String expectedText="The date of birth is not valid";
        String actualText = invalidMessage.getText();

        Assert.assertEquals(expectedText,actualText,"Verify invalid message is displayed");

    }
    @Test
    public void test2(){
       //Verify that following options for programming languages are displayed: c++, java,JavaScript
        WebElement checkBoxC=driver.findElement(By.xpath("//input[@id='inlineCheckbox1']"));
        System.out.println("checkBoxC.isDisplayed() = " + checkBoxC.isDisplayed());
        Assert.assertTrue(checkBoxC.isDisplayed(),"verify checkBox of  the C++ is displayed");

        WebElement checkBoxJava=driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        System.out.println("checkBoxJava.isDisplayed() = " + checkBoxJava.isDisplayed());
        Assert.assertTrue(checkBoxJava.isDisplayed(),"verify checkBox of  the C++ is displayed");


        WebElement checkBoxJavaScript=driver.findElement(By.xpath("//input[@id='inlineCheckbox3']"));
        System.out.println("checkBoxJavaScript.isDisplayed() = " + checkBoxJavaScript.isDisplayed());
        Assert.assertTrue(checkBoxJavaScript.isDisplayed(),"verify checkBox of  theJavaScript is displayed");

    }
    @Test
    public void test3(){
        //Step 3. Enter only one alphabetic character into first  name input box.
        WebElement firstNameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("a");

        //Verify that warning message is displayed:“first name must be more than 2 and less than 64 characters long”
        WebElement firstNameBoxWarningMessage=driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']"));
        System.out.println("firstNameBoxWarningMessage.getText() = " + firstNameBoxWarningMessage.getText());
        String expectedText = "first name must be more than 2 and less than 64 characters long";
        String actualText = firstNameBoxWarningMessage.getText();
        Assert.assertEquals(expectedText,actualText,"verify the warning message is displayed onder the first name box");

        // System.out.println("firstNameBoxWarningMessage.isDisplayed() = " + firstNameBoxWarningMessage.isDisplayed());
       // Assert.assertTrue(firstNameBoxWarningMessage.isDisplayed(),"verify the warning message is displayed onder the first name box");

    }
    @Test
    public void test4(){
        //. Enter only one alphabetic character into last name input box.

        WebElement lastNameBox=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("b");

        //Step 4. Verify that warning message is displayed:The last name must be more than 2 and less than 64 characters long”
        WebElement lastNameBoxWarningMessage=driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']"));
        System.out.println("lastNameBoxWarningMessage.getText() = " + lastNameBoxWarningMessage.getText());
        String expectedText = "The last name must be more than 2 and less than 64 characters long";
        String actualText = lastNameBoxWarningMessage.getText();
        Assert.assertEquals(expectedText,actualText,"verify the warning message is displayed onder the last name box");
    }
    @Test
    public void test5() throws InterruptedException {
        //Step 3. Enter any valid first name.
        WebElement firstNameBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("Mike");

        //Step 4. Enter any valid last name.
        WebElement lastNameBox=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("SMITH");

        //Step 5. Enter any valid user name.
        WebElement userNameBox=driver.findElement(By.xpath("//input[@name='username']"));
        userNameBox.sendKeys("MikeXXX");

        //enter valid mail
        WebElement mailBox=driver.findElement(By.xpath("//input[@name='email']"));
        mailBox.sendKeys("mike@gmail.com");

        // Step 6. Enter any valid password.
        WebElement passwordBox=driver.findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys("19851985");

        // Step 7. Enter any valid phone number.
        WebElement phoneNumberBox=driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumberBox.sendKeys("551-145-8888");

        //Step 8. Select gender.
        WebElement genderRadioButton=driver.findElement(By.xpath("(//input[@name='gender'])[1]"));
        genderRadioButton.click();

        //Step 9. Enter any valid date of birth.
        WebElement dateOfBirthBox=driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirthBox.sendKeys("12/12/1987");

        //Step 10. Select any department.
        WebElement dropdownElement= driver.findElement(By.xpath("//select[@name='department']"));
        Select departmentOfficeDrop = new Select(dropdownElement);
        String expectedOption = "Select your Department/Office";
        String actualOption = departmentOfficeDrop.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        Thread.sleep(2000);
        departmentOfficeDrop.selectByVisibleText("MPDC");
        expectedOption="MPDC";
        actualOption=departmentOfficeDrop.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption,expectedOption,"verify first selected ");

        //Step 11. Enter any job title.
        WebElement jobTitle= driver.findElement(By.xpath("(//select[@class='form-control selectpicker'])[2]"));
        Select jobTitleDropBox = new Select(jobTitle);
       // String expectedOption1 = " Select job type";
       // String actualOption1 = jobTitleDropBox.getFirstSelectedOption().getText();
       // Assert.assertEquals(actualOption1,expectedOption1,"verify first selection");

        Thread.sleep(2000);
        jobTitleDropBox.selectByIndex(4);
        String expectedOption3="SDET";
        String actualOption3=jobTitleDropBox.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption3,expectedOption3,"verify first selected ");

        Thread.sleep(3000);

        //Step 12. Select java as a programming language.
        WebElement programmingLanBox= driver.findElement(By.cssSelector(" #inlineCheckbox1"));
        programmingLanBox.click();

        //Step 13. Click Sign up.
        WebElement signUPButton= driver.findElement(By.cssSelector("#wooden_spoon"));
        signUPButton.click();

        //Step 14. Verify that following success message is displayed: “You've successfully completed registration!
        //driver.get("https://practice-cybertekschool.herokuapp.com/registration_confirmation");
        WebElement verifyMessage= driver.findElement(By.xpath("//div[@class='alert alert-success']/p"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());
        String expectedText="You've successfully completed registration!";
        String actualText = verifyMessage.getText();
        Assert.assertEquals(expectedText,actualText,"verify display successful registration message");




    }








}


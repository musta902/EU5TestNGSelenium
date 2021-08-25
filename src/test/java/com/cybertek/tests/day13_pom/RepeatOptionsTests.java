package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*VERIFY RADIO BUTTONS
    Open Chrome browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */
    //TASK UNTIL 12:45

    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();

        // Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage =new CreateCalendarEventsPage();
        //Click on repeat
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isDisplayed(),"verify repeat days is selected");

        // verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify week day is not selected");

    }
    @Test
    public void test2(){
        LoginPage loginPage=new LoginPage();

        // Login as driver
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage =new CreateCalendarEventsPage();
        //Click on repeat
        createCalendarEventsPage.repeat.click();

        Select repeatsDropdown = createCalendarEventsPage.repeatOptionsList();

        // Verify that repeat options are Daily,weekly ,monthly Yearly(in this order)
        List<String> expectedList= Arrays.asList("Daily","Weekly","Monthly","Yearly");

        List<String> actualList=new ArrayList<>();

        List<WebElement> actualOptions = repeatsDropdown.getOptions();
        for (WebElement option : actualOptions) {
            actualList.add(option.getText());
        }
        //Ready method for getting text of list of web elements
        List<String> actualList2 = BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(actualList,expectedList,"verify Daily Weekly Monthly Yearly");






    }



}

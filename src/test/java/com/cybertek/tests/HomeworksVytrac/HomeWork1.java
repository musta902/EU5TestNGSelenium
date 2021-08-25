package com.cybertek.tests.HomeworksVytrac;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork1 extends TestBase {

    @Test
    public void calendarEvent() {
        //1. Go to “https://qa1.vytrack.com/"
        // driver.get("url");

        //2. Login as a store manager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        System.out.println("calendarEventsPage.getOptions.getText() = " + calendarEventsPage.getOptions.getText());

        //4. Verify that page subtitle "Options" is displayed
        String actualText = calendarEventsPage.getOptions.getText();
        Assert.assertTrue(calendarEventsPage.getOptions.isDisplayed(), "verify the optiosns subtitle displayed");
    }

    @Test
    public void calendarEvent2() {
        //1. Go to “https://qa1.vytrack.com/"
        //driver.get("url");

        //2. Login as a store manager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        //4. Verify that page number is equals to "1"

        try {
            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
            BrowserUtils.waitForVisibility(calendarEventsPage.getPageNumber, 5);
            Assert.assertEquals(calendarEventsPage.getPageNumber.getAttribute("value"), "1", "verify page number as 1");
        } catch (Exception e) {
            System.out.println("wrong");

        }
    }

    @Test
    public void calendarEvent3() {
        //1. Go to “https://qa1.vytrack.com/"
        //driver.get("url");

        //2. Login as a store manager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        //3. Navigate to “Activities -> Calendar Events”
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitForPageToLoad(10);
        System.out.println("calendarEventsPage.getViewPerPage.getText() = " + calendarEventsPage.getViewPerPage.getText());
        Assert.assertEquals(calendarEventsPage.getViewPerPage.getText(),"25","Verify that view per page number is equals to\n" +
                "\"25\"");
    }

    @Test
    public void calendarEvent4() {
        extentLogger = report.createTest("Verify that number of calendar events (rows in the table) is equals to number of records test");

        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        extentLogger = report.createTest("Login as a store manager test");
        LoginPage login = new LoginPage();
        login.loginAsStoreManager();
        //calendarEventsPage.waitUntilLoaderScreenDisappear();

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitForClickablility(calendarEventsPage.perPageBtn, 10);

        //change view per page to 100
        BrowserUtils.clickWithJS( calendarEventsPage.perPageBtn);
        BrowserUtils.clickWithJS(calendarEventsPage.perPage100);

        //Verify that number of calendar events (rows in the table) is equals to number of records
        extentLogger = report.createTest("Verification of number of calendar events (rows in the table) is equals to number of records test");
        BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow, 10);

        //new DashboardPage().waitUntilLoaderScreenDisappear();
        //System.out.println("calendarEventsPage.totalPagesNo.getText() = " + calendarEventsPage.totalPagesNo.getText());
        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        System.out.println("pageNoAsString = " + pageNoAsString);

        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        int rowNo = 0;
        for (int i = 1; i <= pageNoAsInt; i++) {
            rowNo += calendarEventsPage.tableRows.size();
            calendarEventsPage.rightArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
        }

        //System.out.println("calendarEventsPage.totalRecordNo.getText() = " + calendarEventsPage.totalRecordNo.getText().substring(9,13));
        int totalRecordNoAsInt = Integer.parseInt(calendarEventsPage.totalRecordNo.getText().substring(9, calendarEventsPage.totalRecordNo.getText().length() - 8));
        System.out.println("totalRecordNoAsInt = " + totalRecordNoAsInt);
        System.out.println("rowNo = " + rowNo);
        System.out.println("pageNoAsInt = " + pageNoAsInt);
        System.out.println("pageNoAsString = " + pageNoAsString);

        Assert.assertEquals(rowNo, totalRecordNoAsInt, "verify number of calendar events (rows in the table) is equals to number of total records");

        extentLogger.pass("PASS : Verify that number of calendar events (rows in the table) is equals to number of records test");

    }
    @Test
    public void test5(){
        extentLogger= report.createTest("verify that all calendar events were selected");
        DashboardPage dashboardPage = new DashboardPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();



        //Go to “https://qa1.vytrack.com/" (TestBase does this)
        //Login as a store manager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        //Navigate to “Activities -> Calendar Events”
        extentLogger = report.createTest("Navigate to “Activities -> Calendar Events” test");
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //change view per page to 100
        BrowserUtils.clickWithJS( calendarEventsPage.perPageBtn);
        BrowserUtils.clickWithJS(calendarEventsPage.perPage100);

        //4. Click on the top checkbox to select all
        BrowserUtils.waitForClickablility(calendarEventsPage.checkBox, 10);
        BrowserUtils.clickWithJS(calendarEventsPage.checkBox);
        BrowserUtils.waitForPageToLoad(5);

        //5. Verify that all calendar events were selected
     //   extentLogger = report.createTest("verify that all calendar events were selected");
        //Verify that all calendar events were selected
        extentLogger = report.createTest("Verify that all calendar events were selected test");
        BrowserUtils.waitForPageToLoad(5);
        String pageNoAsString = calendarEventsPage.totalPagesNo.getText();
        BrowserUtils.waitForPageToLoad(5);
        pageNoAsString = pageNoAsString.substring(3, pageNoAsString.length() - 2);
        int pageNoAsInt = Integer.parseInt(pageNoAsString);
        System.out.println("pageNoAsInt = " + pageNoAsInt);
        int rowNo = 0;

        for (int i = 1; i <= pageNoAsInt; i++) {

            for (int k = 0; k < calendarEventsPage.tableRows.size(); k++) {
                //System.out.println("row is selected = " + calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected"));

                rowNo++;
                Assert.assertTrue(calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected"), "verify page no:"+i+" and row no: "+rowNo+" : "+calendarEventsPage.tableRows.get(k).getText()+ " is selected");

                /*if (!calendarEventsPage.tableRows.get(k).getAttribute("class").contains("row-selected")) {
                    System.out.println("page no:" + pageNoAsInt + " and row no:" + calendarEventsPage.tableRows.get(calendarEventsPage.tableRows.size()) + " is NOT selected");                    //calendarEventsPage.rightArrow.click();
                    calendarEventsPage.waitUntilLoaderScreenDisappear();
                    break;
                }*/
            }
            calendarEventsPage.rightArrow.click();
            calendarEventsPage.waitUntilLoaderScreenDisappear();
            //BrowserUtils.waitForClickablility(calendarEventsPage.rightArrow,5);
        }
        System.out.println("rowNo = " + rowNo);
        System.out.println("pageNoAsInt = " + pageNoAsInt);

        //System.out.println("calendarEventsPage.totalRecordNo.getText() = " + calendarEventsPage.totalRecordNo.getText().substring(9,13));

        /*String str = calendarEventsPage.totalRecordNo.getText();
        str= str.substring(9,str.length()-8);
        System.out.println("str =" + str);*/


        //Assert.assertEquals(rowNo,Integer.parseInt(calendarEventsPage.totalRecordNo.getText().substring(9,13)),"verify number of calendar events (rows in the table) is equals to number of total records");

        extentLogger.pass("PASS : Verify that all calendar events were selected test");

    }

}



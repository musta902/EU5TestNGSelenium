package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {
    @BeforeClass
    public void beforeClass(){
        System.out.println("--BEFORE CLASS--");

        System.out.println("executed one time before the class");
    }

    @Test
    public void test1(){

        System.out.println("First test Case");

    }
    @Test
    public void test2() {

        System.out.println("second test Case");

    }
    @Ignore
    @Test
    public void test3() {

        System.out.println("Third test Case");
    }

    @BeforeMethod
    public void setUp(){
        System.out.print("--BEFORE METHOD--");
        System.out.println("WebDriver,Opening Browser");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("--AFTER METHOD--");
        System.out.println("Closing browser quit");




    }
    @AfterClass
    public void afterClass(){
        System.out.println("--AFTER CLASS--");

        System.out.println("SOME REPORTING CODE HERE");
    }

}

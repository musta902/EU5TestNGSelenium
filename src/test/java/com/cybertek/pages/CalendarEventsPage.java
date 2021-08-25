package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle']")
    public WebElement getOptions;

    @FindBy(xpath = "//li/input[@value='1']")
    public WebElement getPageNumber;

    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle ')]")
    public WebElement getViewPerPage;


    @FindBy(xpath = "//button[contains(@class,'btn dropdown-toggle')]")
    public WebElement  perPageBtn;

    @FindBy(xpath = "//a[contains(text(),'100')]")
    public  WebElement perPage100;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> tableColumns;

    @FindBy(xpath = "//label[contains(text(),'of')][1]")
    public WebElement totalPagesNo;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public  WebElement rightArrow;

    @FindBy(xpath = "//label[contains(text(),'Total of ')]")
    public WebElement totalRecordNo;

    ////tbody/tr[18]/td[4] row bölümleri
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//button/input")
    public WebElement checkBox;








}
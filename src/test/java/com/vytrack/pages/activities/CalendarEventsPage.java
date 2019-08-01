package com.vytrack.pages.activities;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage {


    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEventBtn;

    @FindBy(css = "[id^='oro_calendar_event_form_title']")
    public WebElement titleInputLocator;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDateLocator;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDateLocator;

    @FindBy(css="a[title='Grid Settings']")
    public WebElement gridSettingsElement;

    @FindBy(css="a[title='Reset']")
    public WebElement resetBtnElement;

    @FindBy(className="grid-header-cell__label")
    public List<WebElement> headers;



    public CalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void selectGridSetting(String name, boolean yesOrNo){
        gridSettingsElement.click();
        String locator = "//td//label[text()='"+name+"']/../following-sibling::td//input";

        WebElement gridOption = Driver.getDriver().findElement(By.xpath(locator));

        if((yesOrNo  && !gridOption.isSelected())  || (
                yesOrNo == false && gridOption.isSelected())){
            gridOption.click();
        }

        Driver.getDriver().findElement(By.cssSelector("span[class='close']")).click();

    }

    public boolean verifyHeaderExists(String headerNameOrColumnName){
        for (WebElement tableHeader: headers){
            if(tableHeader.getText().equalsIgnoreCase(headerNameOrColumnName)){

                return true;
            }
        }
        return false;
    }


}

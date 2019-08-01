package com.vytrack.tests.components.activities;

import com.vytrack.pages.activities.CalendarEventsPage;
import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtils;
import org.testng.annotations.Test;

public class DateAndTimeTests extends TestBase {

    @Test
    public void EndTimeAdjust() {

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        loginPage.login(username,password);
        VYTrackUtils.waitUntilLoaderScreenDisappear();
        VYTrackUtils.navigateToModule("Activities","Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEventBtn.click();
        VYTrackUtils.waitUntilLoaderScreenDisappear();



    }

}

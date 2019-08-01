package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MenuOptionsTestStoreManager {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys("storemanager87");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123", Keys.ENTER);
    }
    @BeforeMethod
    public void setUp(){
        SeleniumUtils.waitPlease(1);
    }
    @AfterMethod
    public void tearsDown(){
        SeleniumUtils.waitPlease(1);

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    @Test(priority = 1)
    public void verifyDashboardPageTitle(){
        String expectedPageTitle = "Dashboard";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

    }
    @Test(priority = 2)
    public void verifyDashboardPageName(){
        String expectedPageName = "Dashboard";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);

    }
    @Test(priority = 3)
    public void verifyVehiclesPageTitle(){
        List<WebElement> tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(1).click();
        SeleniumUtils.waitPlease(1);
        modules.get(2).click();
        SeleniumUtils.waitPlease(1);
        String expectedPageTitle = "Car - Entities - System - Car - Entities – System";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        SeleniumUtils.waitPlease(2);
    }
    @Test(priority = 4)
    public void verifyVehiclesPageName(){
        String expectedPageName = "Cars";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);

    }
    @Test(priority = 5)
    public void verifyAccountsPageTitle(){
        List<WebElement> tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(2).click();
        SeleniumUtils.waitPlease(1);
        modules.get(9).click();
        SeleniumUtils.waitPlease(1);
        String expectedPageTitle = "Accounts - Customers";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        SeleniumUtils.waitPlease(2);

    }
    @Test(priority = 6)
    public void verifyAccountsPageName(){
        String expectedPageName = "Accounts";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }
    @Test(priority = 7)
    public void verifyContractsPageTitle(){
        List<WebElement> tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(2).click();
        SeleniumUtils.waitPlease(1);
        modules.get(10).click();
        SeleniumUtils.waitPlease(1);
        String expectedPageTitle = "Accounts - Customers";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        SeleniumUtils.waitPlease(2);

    }
    @Test(priority = 8)
    public void verifyContractsPageName(){
        String expectedPageName = "Contacts";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }
    @Test(priority = 9)
    public void verifyOpportunitiesPageTitle(){
        List<WebElement> tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(3).click();
        SeleniumUtils.waitPlease(1);
        modules.get(11).click();
        SeleniumUtils.waitPlease(1);
        String expectedPageTitle = "Open Opportunities - Opportunities - Sales";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        SeleniumUtils.waitPlease(2);
    }
    @Test(priority = 10)
    public void verifyOpportunitiesPageName(){
        String expectedPageName = "Open Opportunities";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }
    @Test(priority = 11)
    public void verifyCallsPageTitle(){
        List<WebElement> tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(4).click();
        SeleniumUtils.waitPlease(1);
        modules.get(12).click();
        SeleniumUtils.waitPlease(1);
        String expectedPageTitle = "Calendar Events - Activities";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        SeleniumUtils.waitPlease(2);
    }
    @Test(priority = 12)
    public void verifyCallsPageName(){
        String expectedPageName = "All Calls";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }
    @Test(priority = 13)
    public void verifyCalendarEventsPageTittle(){
        List<WebElement> tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(4).click();
        SeleniumUtils.waitPlease(1);
        modules.get(13).click();
        SeleniumUtils.waitPlease(1);
        String expectedPageTitle = "Calendar Events - Activities";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        SeleniumUtils.waitPlease(2);
    }
    @Test(priority = 14)
    public void verifyCalendarEventsPageName(){
        String expectedPageName = "Calendar Events";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }


}


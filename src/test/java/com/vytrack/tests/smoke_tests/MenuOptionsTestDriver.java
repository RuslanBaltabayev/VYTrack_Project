package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MenuOptionsTestDriver {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user153");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("UserUser123");
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }
   @AfterClass
   public void afterClass(){
        SeleniumUtils.waitPlease(2);
       driver.quit();
   }
    @BeforeMethod
    public void setUp(){
        SeleniumUtils.waitPlease(4);
    }
    @AfterMethod
    public void tearDown(){
        SeleniumUtils.waitPlease(1);
    }

    @Test(priority = 1)
    public void verifyVehiclesPageTitle(){
        List<WebElement>tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(0).click();
        SeleniumUtils.waitPlease(2);
        modules.get(0).click();
        SeleniumUtils.waitPlease(2);
        String expectedPageTitle = "Car - Entities - System - Car - Entities - System";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

    }
    @Test(priority = 2)
    public void verifyVehiclesPageName(){
        String expectedPageName ="Cars";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }
    @Test(priority=3)
    public void verifyAccountsPageTitle(){
        List<WebElement>tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(1).click();
        SeleniumUtils.waitPlease(2);
        modules.get(7).click();
        SeleniumUtils.waitPlease(2);
        String expectedPageTitle = "Accounts - Customers";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

    }
    @Test(priority = 4)
    public void verifyAccountsPageName(){
        String expectedPageName = "Accounts";
        String actualPageName =driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }
    @Test(priority = 5)
    public void verifyContactsPageTitle(){
        List<WebElement>tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(1).click();
        SeleniumUtils.waitPlease(2);
        modules.get(8).click();
        SeleniumUtils.waitPlease(2);
        String expectedPageTitle = "Contacts - Customers";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

    }
    @Test(priority = 6)
    public void verifyContactsPageName(){
        String expectedPageName = "Contacts";
        String actualPageName =driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }
    @Test(priority = 7)
    public void verifyCalendarEventTitle(){
        List<WebElement>tabs=driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        List<WebElement>modules=driver.findElements(By.xpath("//span[@class='title title-level-2']"));
        tabs.get(2).click();
        SeleniumUtils.waitPlease(2);
        modules.get(9).click();
        SeleniumUtils.waitPlease(2);
        String expectedPageTitle = "Calendar Events - Activities";
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
    }
    @Test(priority = 8)
    public void verifyCalendarEventName(){
        String expectedPageName = "Calendar Events";
        String actualPageName =driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }
}

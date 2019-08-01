package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.VYTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageAccessTest {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

    }
    @Test(priority = 1)
    public void verifyStoreManagerAccessVehicleContractsPage(){
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager87");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        VYTrackUtils.navigateToModule("Fleet","Vehicle Contracts");
        SeleniumUtils.waitPlease(1);
        String expected = "All Vehicle Contract";
        String actual = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 2)
    public void verifySalesManegerAccessVehicleContractsPage(){
        VYTrackUtils.login(driver,"salesmanager253","UserUser123");
        VYTrackUtils.navigateToModule("Fleet","Vehicle Contracts");
        SeleniumUtils.waitPlease(1);
        String expected  = "All Vehicle Contract";
        String actual = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
    }
    @Test(priority = 3)
    public void verifyTrackDriverNotAccessVehicleContractsPage(){
        VYTrackUtils.login(driver,"user153","UserUser123");
        VYTrackUtils.navigateToModule("Fleet","Vehicle Contracts");
        SeleniumUtils.waitPlease(1);
        String expected = "You do not have permission to perform this action.";
        String actual = driver.findElement(By.xpath("//div[@class='message' and contains(text(),'You do not have permission to perform this action.')]")).getText();
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

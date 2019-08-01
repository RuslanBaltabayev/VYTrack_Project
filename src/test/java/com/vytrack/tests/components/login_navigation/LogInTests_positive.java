package com.vytrack.tests.components.login_navigation;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LogInTests_positive {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

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
    public void loginAsStoreManager(){
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager87");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        SeleniumUtils.waitPlease(2);

    }
    @Test(priority = 2)
    public void verifyUserNameIsDisplayed(){
        String expectedUserName = "Alena Hagenes";
        String actualUserName = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Alena Hagenes')]")).getText();
        Assert.assertTrue(expectedUserName.equals(actualUserName));
        System.out.println("Verify User Name is Displayed ---> "+expectedUserName.equals(actualUserName));
    }
    @Test(priority = 3)
    public void verifyDashboardPageIsOpen(){
    String expectedPageName = "Dashboard";
    String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
    Assert.assertTrue(expectedPageName.equals(actualPageName));
        System.out.println("Verify Dashboard Page is Open ---> "+expectedPageName.equals(actualPageName));
    }
    @Test(priority = 4)
    public void logout1(){
        driver.findElement(By.xpath("//*[@class='fa-caret-down']")).click();
        driver.findElement(By.xpath("//*[@class='no-hash'and contains(text(),'Logout')]")).click();
        System.out.println("Logout successifully --->         "+driver.findElement(By.id("_submit")).isDisplayed());
        SeleniumUtils.waitPlease(2);
    }
   @Test(priority = 5)
    public void loginAsSalesManager(){
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager253");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123",Keys.ENTER);
        SeleniumUtils.waitPlease(2);
    }
    @Test(priority = 6)
    public void verifyDashboardPageIsOpen2(){
        String expectedPageName = "Dashboard";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertTrue(expectedPageName.equals(actualPageName));
        System.out.println("Verify Dashboard Page is Open ---> "+expectedPageName.equals(actualPageName));
    }
    @Test(priority = 7)
    public void verifyNameisDifferent1(){
        String expectedUserName = "Alberto Bins";
        String actualUserName = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Alberto Bins')]")).getText();
        Assert.assertTrue(expectedUserName.equals(actualUserName));
        System.out.println("Verify Name is different  --->  "+expectedUserName.equals(actualUserName));

    }
    @Test(priority = 8)
    public void logout2(){
        driver.findElement(By.xpath("//*[@class='fa-caret-down']")).click();
        driver.findElement(By.xpath("//*[@class='no-hash'and contains(text(),'Logout')]")).click();
        System.out.println("Logout successifully --->          "+driver.findElement(By.id("_submit")).isDisplayed());
        SeleniumUtils.waitPlease(2);
    }
    @Test(priority = 9)
    public void loginAsDriver(){
        driver.findElement(By.id("prependedInput")).sendKeys("user153");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123",Keys.ENTER);
        SeleniumUtils.waitPlease(2);
    }
    @Test(priority = 10)
    public void verifyDashboardTrackDriverPageIsOpen(){
        String expectedPageName = "Quick Launchpad";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        SeleniumUtils.waitPlease(1);
       Assert.assertTrue(expectedPageName.equals(actualPageName));
       System.out.println("Verify Dashboard Page is Open ---> "+expectedPageName.equals(actualPageName));
    }
    @Test(priority = 11)
    public void verifyNameisDifferent2(){
        String expectedUserName = "Myrna Hoppe";
        String actualUserName = driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Myrna Hoppe')]")).getText();
        Assert.assertTrue(expectedUserName.equals(actualUserName));
        System.out.println("Verify Name is different  --->  "+expectedUserName.equals(actualUserName));

    }
    @Test(priority = 12)
    public void logout3(){
        driver.findElement(By.xpath("//*[@class='fa-caret-down']")).click();
        driver.findElement(By.xpath("//*[@class='no-hash'and contains(text(),'Logout')]")).click();
        System.out.println("Logout successifully --->         "+driver.findElement(By.id("_submit")).isDisplayed());
    }





}

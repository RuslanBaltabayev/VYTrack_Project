package com.vytrack.tests.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInTest_negative {

    WebDriver driver;

@BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
    }
    @Test
    public void loginwithincorrectcpassword(){
        driver.findElement(By.id("prependedInput")).sendKeys("user153");
        driver.findElement(By.id("prependedInput2")).sendKeys("useruser123", Keys.ENTER);
        boolean popup = driver.findElement(By.xpath("//*[@class='alert alert-error']")).isDisplayed();
        System.out.println("Invalid user name or password message popup: "+popup);
        String expectedPageTitle = "Login";
        String actualPageTite = driver.getTitle();
        String expectedUrl = "http://qa2.vytrack.com/user/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualPageTite,expectedPageTitle);
        Assert.assertEquals(actualUrl,expectedUrl);
    }
}

package com.vytrack.tests.regression_tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class practice {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method");
    }
    @Test
    public void test1(){
        String str1 = "java";
        String str2 = "java";
        System.out.println("befor assertion");
        Assert.assertEquals(str1,str2);
        System.out.println("after assertion");
        String str3 = "javac";
        Assert.assertEquals(str1,str3);
        System.out.println("after 2nd assertion");
    }

    @Test
    public void test2() {
        String str1 = "javac";
        String str2 = "javac";
        System.out.println("befor assertion");
        Assert.assertEquals(str1, str2);
        System.out.println("after assertion");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }
    @AfterMethod
    public void teardown(){
        System.out.println("After method");
    }



}

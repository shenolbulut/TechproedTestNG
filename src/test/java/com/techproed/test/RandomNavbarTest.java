package com.techproed.test;

import com.techproed.pages.Dashboard;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class RandomNavbarTest {

    Dashboard dashboard=new Dashboard();

    @BeforeMethod
    public void test(){

        Driver.get().get(ConfigurationReader.get("hepsiburada"));


    }

    @Test
    public void test1() throws InterruptedException {

        Assert.assertTrue(dashboard.checkNavBar("Moda"));


    }




}

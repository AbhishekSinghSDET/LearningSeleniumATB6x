package com.actionss;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Lab28_RelativeLocator {

    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver = new ChromeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testPositive() throws InterruptedException {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");
        driver.manage().window().maximize();
        Thread.sleep(15000);

        // iframe
        driver.switchTo().frame("result");


        WebElement submit = driver.findElement(By.xpath("//form[@id=\"form\"]/button"));

        submit.click();

        //

        WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement errorElement =  driver.findElement(with(By.tagName("small")).below(element));
        String errorText = errorElement.getText();
        Assert.assertTrue(errorElement.isDisplayed());
        Assert.assertEquals(errorText,"Username must be at least 3 characters");


        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser () {
        driver.quit();
    }
}

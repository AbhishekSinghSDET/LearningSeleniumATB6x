package com.actionss;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab29_TryCatch {

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

        try {
            driver.manage().window().maximize();
            driver.get("https://google.com");
            WebElement ele = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]"));
            driver.navigate().refresh();
            WebElement ele2 = driver.findElement(By.xpath("//*[@class=\"gLFyf\"]"));
            ele2.sendKeys("The Testing Academy");
            // Refresh, Navigate other Page, change in DOM elements (Ajax Calls) - VueJS, AngularJS

            //  b1 - found driver
            // b1 remove
            // b1.click -> ? No such element

//        driver.switchTo().frame(1);
            //driver.switchTo().alert().accept();
        } catch (StaleElementReferenceException | NoSuchElementException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    @AfterTest
    public void closeBrowser () {
        driver.quit();
    }
}

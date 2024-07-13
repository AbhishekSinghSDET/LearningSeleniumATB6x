package com.testing;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab007 {

    @Test
    public void vwoNegativeTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");


        driver.findElement(By.id("login-username")).sendKeys("test@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("test");
        driver.findElement(By.id("js-login-btn")).click();

        Thread.sleep(2000);
        String text = driver.findElement(By.className("notification-box-description")).getText();
        Assert.assertEquals(text,"Your email, password, IP address or location did not match");

        driver.findElement(By.linkText("Start a free trial")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}

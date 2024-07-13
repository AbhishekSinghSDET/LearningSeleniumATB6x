package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment1 {

    @Test
    public void tescase1() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");

        driver.findElement(By.linkText("Start a free trial")).click();

        WebElement enterEmail = driver.findElement(By.id("page-v1-step1-email"));
        enterEmail.sendKeys("16abhisingh@gmail.com");

        WebElement btnFreeTrial = driver.findElement(By.xpath("//button[text()='Create a Free Trial Account']"));
        btnFreeTrial.click();;
        Thread.sleep(5000);

        String errMsg = driver.findElement(By.className("invalid-reason")).getText();
        System.out.println(errMsg);
        Assert.assertEquals(errMsg,"An account with this email already exists. Login Here");


        Thread.sleep(5000);
        driver.quit();

    }
}

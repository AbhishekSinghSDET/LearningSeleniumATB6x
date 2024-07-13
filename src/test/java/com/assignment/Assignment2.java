package com.assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment2 {

    @Test
    public void testLogin() throws InterruptedException {
        //katalon-demo-cura.herokuapp
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://katalon-demo-cura.herokuapp.com");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");

        driver.findElement(By.id("btn-make-appointment")).click();

        WebElement txtUsername = driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]"));
        String username = txtUsername.getAttribute("value");

        WebElement txtPassword = driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]"));
        String password = txtPassword.getAttribute("value");

        WebElement enterUsername = driver.findElement(By.id("txt-username"));
        enterUsername.sendKeys(username);

        WebElement enterPassword = driver.findElement(By.id("txt-password"));
        enterPassword.sendKeys(password);

        driver.findElement(By.id("btn-login")).click();
        Thread.sleep(2000);

//        Alert alert = driver.switchTo().alert();
//        alert.accept();

        String text = driver.findElement(By.xpath("//section[@id='appointment']//h2")).getText();
        Assert.assertEquals(text,"Make Appointment");

        Thread.sleep(2000);
        driver.quit();

    }
}

package com.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment4 {
    WebDriver driver;

    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
    }

    @Test(groups="QA")
    @Description("Search Products and Print title")
    public void test() throws InterruptedException {

        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("macromini");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#gh-btn")).click();

        Thread.sleep(5000);

        List<WebElement> names =  driver.findElements(By.cssSelector("ul.srp-results.srp-list.clearfix li span[role='heading']"));
        List<WebElement> price = driver.findElements(By.cssSelector("ul.srp-results.srp-list.clearfix li span.s-item__price"));

        //below step is written because title might be extra
        int name = Math.min(names.size(),price.size());
        for(int i = 0; i<name;i++){
            System.out.println(names.get(i).getText() + " : " + price.get(i).getText());
        }

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

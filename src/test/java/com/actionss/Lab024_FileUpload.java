package com.actionss;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab024_FileUpload {

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
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
//        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        //actions.dragAndDrop(from,to).perform();


        actions.clickAndHold(from).moveToElement(to).release(to).build().perform();


        Thread.sleep(4000);


        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement uploadFileInput = driver.findElement(By.id("fileToUpload"));
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        uploadFileInput.sendKeys(dir + "/src/test/java/com/thetestingacademy/selenium31032024/toUpload.txt");
        driver.findElement(By.name("submit")).click();


        // Download File
        // Checked by the ChromeOption
        // Problem - Download a file and check in the dir if that is present.
        // ChromeOptions -> dir(Doc)
        // filename.doc ->  /User/pramod/Download/chrome
        // file exist - T
    }

    @AfterTest
    public void closeBrowser () {
        driver.quit();
    }
}

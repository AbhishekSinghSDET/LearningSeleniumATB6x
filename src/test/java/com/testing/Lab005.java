package com.testing;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lab005 {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        //There are 3 tyoes of page strategies:
        //1. EAGER - I will only wait for DOM elements to be available
        //2. NONE - I will not wait for anything
        //3. NORMAL - I will wait till all the resources are downloaded (80% time it is used)
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");

        driver.quit();
    }
}

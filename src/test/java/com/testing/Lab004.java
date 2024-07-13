package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Lab004 {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        //Browser - can be in headless or full mode
        //Headless - no UI, performance will be fast, less execution tome

        options.addArguments("--start-maximized");
       // options.addArguments("--window-size=800,600");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com");


        driver.quit();

    }
}

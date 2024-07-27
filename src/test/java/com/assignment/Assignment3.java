package com.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("macromini");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#gh-btn")).click();

        Thread.sleep(5000);

        List<WebElement> names =  driver.findElements(By.cssSelector("ul.srp-results.srp-list.clearfix li span[role='heading']"));
        List<WebElement> price = driver.findElements(By.cssSelector("ul.srp-results.srp-list.clearfix li span.s-item__price"));

        //below step is written because title might be extra
        int name = Math.min(names.size(),price.size());


        HashMap<String,String> map = new LinkedHashMap<>();

        for(int i = 0; i<name;i++){
            map.put(names.get(i).getText(),price.get(i).getText());
        }

        for(Map.Entry<String, String> s : map.entrySet()){
            System.out.println(s.getKey()+" : "+s.getValue());
        }


        System.out.println("\n*********Print using for loop***********\n*");
        for(int i = 0; i<name;i++){
            System.out.println(names.get(i).getText() + " : " + price.get(i).getText());
        }

        driver.quit();

    }
}

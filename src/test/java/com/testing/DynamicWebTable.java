package com.testing;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class DynamicWebTable {

    ChromeDriver driver;

    @BeforeTest
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Test Case Description")
    public void testLab328() throws InterruptedException {
        driver.manage().window().maximize();
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement table = driver. findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        List<WebElement> rows_tables = table.findElements(By.tagName("tr"));
        System.out.println("No of rows: "+rows_tables.size());
        
        for (int i = 0; i < rows_tables.size(); i++) {
            List<WebElement> col = rows_tables.get(i).findElements(By.tagName("td"));
            for(WebElement c:col){
                System.out.print(c.getText()+" ");
            }
            System.out.println();

        }





    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}

package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        int row = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']//th")).size();

        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        for (int i = 2; i < row; i++) {
            for (int j = 1; j <= col; j++) {
                String dynamic_xpath = first_part + i + second_part + j + third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                // System.out.print(data+" ");
                if (data.contains("Helen Bennett")) {
                    String country_path = dynamic_xpath + "/following-sibling::td";
                    String country_company = dynamic_xpath + "/preceding-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_path)).getText();
                    String company_text = driver.findElement(By.xpath(country_company)).getText();
                    System.out.println("------");
                    System.out.println("Helen Bennett is In - " + country_text);
                    System.out.println("Helen Bennett is Company - " + company_text);
                }
                //System.out.println();
            }

        }
        driver.quit();
    }
}

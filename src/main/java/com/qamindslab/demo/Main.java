package com.qamindslab.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://manual01.qaminds.com/ManualT/");

        WebElement searchBox = driver.findElement(By.name("s"));
        searchBox.sendKeys("tshirt");
        searchBox.sendKeys(Keys.ENTER);

        WebElement searchResultsHeader = driver.findElement(By.tagName("h1"));
        System.out.println(searchResultsHeader.getText());

        List<WebElement> pageOne = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/main/div/ul/li"));
        System.out.println(pageOne.size());

        List<WebElement> paginationList = driver.findElements(By.xpath("//*[@id=\"main\"]/div/nav[2]/ul/li"));
        if((paginationList.get(paginationList.size() -1).findElement(By.tagName("a")).getAttribute("class")).contains("next")){
            paginationList.get(paginationList.size() -1).click();
        }

        List<WebElement> pageTwo = driver.findElements(By.xpath("//*[@id=\"main\"]/div/ul/li"));

        System.out.println(pageTwo.size());
        System.out.println("Total number of items founds: " + (pageOne.size() + pageTwo.size()));
        System.out.println(driver.findElement(By.xpath("//*[@id=\"main\"]/div/p")).getText());

        driver.close();
        driver.quit();
    }
}

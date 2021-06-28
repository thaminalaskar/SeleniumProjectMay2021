package com.peoplentech.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    //object of Logger
    private static Logger logger = Logger.getLogger(TestBase.class);

    public static void setupBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() {
        waitFor(5);
        driver.quit();
    }

    //Before we parameterized Thread.sleep
    //public static void closeBrowser() throws InterruptedException {
    //Thread.sleep(5000);
    // driver.quit();
    // }

    public void clickOnLinkText(String lnkTxt) {
        driver.findElement(By.linkText(lnkTxt)).click();
    }

    public void typeOnXpath(String xpath, String data) {
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }

    public void clickOnXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void clickOnId(String id) {
        driver.findElement(By.id(id)).click();
    }
    //Test case before we added driver.navigate().back();
    //@Test
    //public void validateUserCanClickOnRegisterButton() throws InterruptedException{
    //setupBrowser("chrome", "https://www.ebay.com");
    //clickOnLinkText("register");
    //closeBrowser();
    //}

    public static void navigateBack() {
        driver.navigate().back();
    }
}



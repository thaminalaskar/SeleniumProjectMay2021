package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverLaunch3 {

    private static WebDriver driver;

    public static void setupBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
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

    public void clickOnXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void clickOnId(String id){
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

    @Test
    public void validateUserCanClickOnRegisterButton() {
        setupBrowser("chrome", "https://www.ebay.com");
        clickOnLinkText("register");
        navigateBack();
        closeBrowser();
    }

    //Test case with driver.navigate().back();
    //@Test
    //public void validateUserCanClickOnRegisterButton(){
    //setupBrowser("chrome", "https://www.ebay.com");
    //clickOnLinkText("register");
    //driver.navigate().back();
    //closeBrowser();
    //}
    @Test
    public void validateUserCanClickOnSignInButton() throws InterruptedException {
        setupBrowser("chrome", "https://www.ebay.com");
        clickOnLinkText("Sign in");
        closeBrowser();
    }

    //Before Thread.sleep is parameterized and waitFor is added
    //@Test
    //public void validateUserCanSearchForAnItem() throws InterruptedException{
    //setupBrowser("firefox", "https://www.amazon.com");
    //typeOnXpath("//input[@id='twotabsearchtextbox']", "Computer Paper");
    //closeBrowser();
    //}

    @Test
    public void validateUserCanSearchForAnItemInAmazon() {
        setupBrowser("firefox", "https://www.amazon.com");
        waitFor(2);
        typeOnXpath("//input[@id='twotabsearchtextbox']", "Computer Paper");
        closeBrowser();
    }

    @Test
    public void validateUserCanSearchForAnItemInEbay() {
        setupBrowser("chrome", "https://www.ebay.com");
        waitFor(3);
        typeOnXpath("//input[@id='gh-ac']", "Selenium Books");
        clickOnId("gh-btn");
        closeBrowser();
    }
}




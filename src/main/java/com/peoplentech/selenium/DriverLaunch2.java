package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverLaunch2 {

    //public static void main(String[] args) throws InterruptedException {

    //Beginning---> Will be the same
    //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
    //WebDriver driver = new ChromeDriver();
    //driver.get("https://www.ebay.com");


    //driver.findElement(By.id("gh-ac")).sendKeys("Java Books");

    //driver.findElement(By.id("gh-btn")).click();


    // Task During Class
    //driver.findElement(By.linkText("register")).click(); //--->Zann used this

    //driver.findElement(By.xpath("//a[@_sp='m570.l2621']")).click();

    //driver.findElement(By.id("firstname")).sendKeys("Tina");


    //End---> Will be the same
    //Thread.sleep(5000);
    //driver.quit();


    private static WebDriver driver;

    //Before We Parameterized The Code We Used This One
    //public static void setupBrowser() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //driver = new ChromeDriver();
        //driver.get("https://www.ebay.com");
    //}

    // Before we used Firefox
    //public static void setupBrowser(String url) {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        //driver = new ChromeDriver();
        //driver.get(url);
    //}

    // Before We Parameterize further to be able to use both browsers
    //public static void setupBrowser(String url) {
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        //driver = new FirefoxDriver();
        //driver.get(url);

    public static void setupBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }else {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get(url);
    }

    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    //public static void main(String[] args) throws InterruptedException {
    //setupBrowser();
    //driver.findElement(By.linkText("register")).click();
    //driver.findElement(By.id("firstname")).sendKeys("Tina");
    //closeBrowser();

    @Test
    public void validateUserCanClickOnRegisterButton() throws InterruptedException {
        setupBrowser("chrome", "https://www.ebay.com");
        driver.findElement(By.linkText("register")).click();
        closeBrowser();

    }

    @Test
    public void validateUserCanClickOnSignInButton() throws InterruptedException {
        setupBrowser("chrome", "https://www.ebay.com");
        driver.findElement(By.linkText("Sign in")).click();
        closeBrowser();
    }

    @Test
    public void validateUserCanSearchForAnItem() throws InterruptedException {
        setupBrowser("firefox", "https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computer Paper");
        closeBrowser();
    }
}


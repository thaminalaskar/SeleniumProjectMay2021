package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLaunch1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");

        // interface object = new constructor of the chromedriver class
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        //driver.findElement(By.className("gLFyf gsfi")).sendKeys("Java Books"); ---> Does Not Work Using Class Name

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Java Books");

        Thread.sleep(2000);

        //driver.findElement(By.className("gN089b")).click(); ---> Does Not Work Using Class Name

        driver.findElement(By.xpath("//input[@aria-label='Google Search']")).click();


        Thread.sleep(5000);

        driver.quit();


    }
}

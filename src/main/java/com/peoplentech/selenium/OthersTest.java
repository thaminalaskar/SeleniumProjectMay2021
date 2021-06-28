package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OthersTest extends TestBase {

    @Test
    public void userShouldBeAbleToPerformDragNdrop() {
        setupBrowser("chrome", "http://demo.guru99.com/test/drag_drop.html");

        WebElement source = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement destination = driver.findElement(By.id("amt7"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();

        closeBrowser();
    }

    @Test
    public void userShouldBeAbleToPerformIframes() {
        setupBrowser("chrome", "https://demoqa.com/frames");

        //we can also use index for an integer
        driver.switchTo().frame("frame2");
        //driver.findElement(By.id("Click Me")).click();

        waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        driver.switchTo().defaultContent();
        waitFor(5);

        js.executeScript("window.scrollBy(0,1000)");

        closeBrowser();
    }


}

package org.digital;

import org.digital.driver.ChromeWebDriver;
import org.digital.driver.Driver;
import org.digital.driver.EdgeWebDriver;
import org.digital.helper.AlertHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {

        public static void main(String[] args) {

            WebDriver driver = ChromeWebDriver.loadChromeDriver();
            driver.get("https://www.google.com/");

        }
        WebDriver driver;
        @BeforeClass
        public void setIp(){
            driver =  EdgeWebDriver.loadEdgeDriver();;
        }

        @Test
        void test1() throws InterruptedException {
            driver.get("https://demoqa.com/alerts");
            driver.findElement(By.id("alertButton")).click();
            Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
            alert.accept();
            driver.findElement(By.id("timerAlertButton")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();

            driver.findElement(By.id("confirmButton")).click();
            alert.dismiss();

            driver.findElement(By.id("promtButton")).click();
            alert.sendKeys("Nur");
            alert.accept();
        }

        @Test
        public void testToAlert() throws InterruptedException {
            WebDriver driver = Driver.getDriver();
            AlertHelper alertHelper = new AlertHelper(driver);
            driver.get("https://demoqa.com/alerts/");
            driver.findElement(By.id("alertButton")).click();
            Thread.sleep(5000);
            alertHelper.acceptAlert();
            driver.findElement(By.id("timerAlertButton")).click();
            Thread.sleep(2000);
            alertHelper.acceptAlert();
        }

        @Test
        void test3() {
            driver.get("https://demoqa.com/frames");
            driver.switchTo().frame("frame1");
            WebElement text = driver.findElement(By.tagName("h1"));
            System.out.println(text.getText());
            driver.switchTo().defaultContent();
            WebElement div = driver.findElement(By.xpath("//div[@id='framesWrapper']/div"));
            System.out.println(div.getText());
        }

        @Test
        void test4() {
            driver.get("https://demoqa.com/nestedframes");
            //first go to parent frame
            driver.switchTo().frame("frame1");
            // then go to child frame
            driver.switchTo().frame(0);
            System.out.println(driver.findElement(By.tagName("p")).getText());
            driver.switchTo().parentFrame();
            System.out.println(driver.findElement(By.tagName("body")).getText());
            driver.switchTo().defaultContent();
        }

        @Test
        void test5() {
            driver.get("https://www.google.com/");
        }
    }

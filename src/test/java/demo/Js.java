package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Js extends BaseTest{

    @Test
    void demo1() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.location='https://demoqa.com/text-box'");

        WebElement fullName = driver.findElement(By.id("userName"));

        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", fullName, "border: 2px solid red");

        Thread.sleep(5000);


        WebElement email = driver.findElement(By.id("userEmail"));

        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", email, "border: 2px solid red");

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));

        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", currentAddress, "border: 2px solid red");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        js.executeScript("arguments[0].setAttribute('style',arguments[1]);", permanentAddress, "border: 2px solid red");


        WebElement submit = driver.findElement(By.id("submit"));

        js.executeScript("arguments[0].click()",submit);

        Thread.sleep(8000);
    }}


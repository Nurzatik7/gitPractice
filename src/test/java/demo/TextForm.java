package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextForm {
    @Test
    void fillUpTheForms() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //?

        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstNameInputField = driver.findElement(By.id("firstName"));
        String expectedFirstName = "Nur";
        firstNameInputField.sendKeys(expectedFirstName);

        WebElement lastNameInputField = driver.findElement(By.id("lastName"));
        String expectedLastName = "Jeldenova";
        lastNameInputField.sendKeys(expectedLastName);

        WebElement emailField = driver.findElement(By.id("userEmail"));
        String expectedEmail = "moonlight.j@mail.ru";
        emailField.sendKeys(expectedEmail);


//        WebElement overlayElement = driver.findElement(By.id("gender-radio-1"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", overlayElement);
//        WebElement femaleButton = driver.findElement(By.id("gender-radio-2"));
//        femaleButton.click();


        WebElement phoneNumberField = driver.findElement(By.id("userNumber"));
        String expectedNumber = "0777070707";
        phoneNumberField.sendKeys(expectedNumber);

        WebElement birthdayInput = driver.findElement(By.id("dateOfBirthInput"));
        String expectedDate = "07.07.1993";
        birthdayInput.sendKeys(expectedDate);

        WebElement resultFirstName = driver.findElement(By.id("name"));
        System.out.println(resultFirstName.getText());
        Assert.assertTrue(resultFirstName.getText().contains(expectedFirstName));


        WebElement resultEmail = driver.findElement(By.id("email"));
        Assert.assertTrue(resultEmail.getText().contains(expectedEmail));


        WebElement resultMobileNumber = driver.findElement(By.xpath("//p[@id='dateOfBirth-label']"));
        Assert.assertTrue(resultMobileNumber.getText().contains(expectedNumber));

        WebElement resultDateOfBirth = driver.findElement(By.xpath("//p[@id='dateOfBirthInput']"));
        Assert.assertTrue(resultDateOfBirth.getText().contains(expectedDate));


    }
    }

package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBox {

    @Test
    void fillUpTheFormTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup(); // позволяет доступ к браузеру

        WebDriver driver = new ChromeDriver(); // create new object

        driver.manage().window().maximize(); // это значит,что нужно окошко расширить

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // setup the time

        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        String expectedFullName = "John Doe";

        fullNameInputField.sendKeys(expectedFullName);

        WebElement emailField = driver.findElement(By.id("userEmail"));

        String expectedEmail = "john@gmail.com";

        emailField.sendKeys(expectedEmail);

        WebElement fullCurrentAddress = driver.findElement(By.id("currentAddress"));

        String expectedCurrentAddress = "Baytik";

        fullCurrentAddress.sendKeys(expectedCurrentAddress);

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));

        String expectedPermanentAddress = "TOKTOGULA";

        permanentAddress.sendKeys(expectedPermanentAddress);

        WebElement submitBtn = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitBtn);
        submitBtn.click();
        Thread.sleep(5000);

        WebElement resultName = driver.findElement(By.id("name"));
        System.out.println(resultName.getText());
        Assert.assertTrue(resultName.getText().contains(expectedFullName));

        WebElement resultEmail = driver.findElement(By.id("email"));
        Assert.assertTrue(resultEmail.getText().contains(expectedEmail));

        WebElement resultCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        Assert.assertTrue(resultCurrentAddress.getText().contains(expectedCurrentAddress));

        WebElement resultPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        Assert.assertTrue(resultPermanentAddress.getText().contains(expectedPermanentAddress));

    }
}


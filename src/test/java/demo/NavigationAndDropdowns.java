package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NavigationAndDropdowns extends BaseTest{

    @Test
    void demo2() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        WebElement element = driver.findElement(By.id("oldSelectMenu"));

        Select select = new Select(element);
        select.selectByVisibleText("Green");
        Thread.sleep(3000);


        select.selectByValue("4");
        Thread.sleep(3000);

        select.selectByIndex(7);
        Thread.sleep(3000);

        List<WebElement> selectedOptions = select.getOptions();

        for (WebElement options : selectedOptions) {
            System.out.println(options.getText());
        }
        {
        }
    }}

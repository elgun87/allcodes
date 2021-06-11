package UdemySelenium;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome",20);
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(url);
        WebElement input = driver.findElement(By.id("name"));
        input.sendKeys("Elgun Guluyev");
        Thread.sleep(2000);
        WebElement alertBtn = driver.findElement(By.cssSelector("[id='alertbtn'"));
        alertBtn.click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.switchTo().alert().getText().contains("Elgun"));
        driver.switchTo().alert().accept();

    }
}

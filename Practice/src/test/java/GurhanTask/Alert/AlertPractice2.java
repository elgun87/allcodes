package GurhanTask.Alert;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertPractice2 {
    WebDriver driver;
    @BeforeClass
    public void setDriver(){
        driver = Driver.getDriver("chrome",15);
        String url = "http://practice.cybertekschool.com/javascript_alerts";
        driver.get(url);
    }
    @Test
    public void test1(){
        WebElement jsConfirm = driver.findElement(By.xpath("//div[@class='container']//button[2]"));
        jsConfirm.click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//div[@class='container']//p[2]"));
        String actual = result.getText();
        String expected = "You clicked: Ok";
        Assert.assertEquals(actual,expected);

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}

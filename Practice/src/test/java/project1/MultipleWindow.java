package project1;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleWindow {
    WebDriver driver;
    @BeforeClass
    public void setDriver(){
        driver = Driver.getDriver("chrome",5);
        String url = "https://www.amazon.com";
        driver.get(url);
    }
    @Test
    public void test1(){
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.amazon.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.etsy.com','_blank');");
    }
}

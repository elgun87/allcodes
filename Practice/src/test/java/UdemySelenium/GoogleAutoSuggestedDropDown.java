package UdemySelenium;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

import java.util.concurrent.TimeUnit;

public class GoogleAutoSuggestedDropDown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome", 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.xpath("//input[@title='Search']"));
        search.sendKeys("baku");
        List<WebElement> allElements = driver.findElements(By.xpath("//ul[@role='listbox']//li/div/div/div"));
        for(WebElement each : allElements){
            if(each.getText().equalsIgnoreCase("Baku")){
                Thread.sleep(1000);
                each.click();
                break;
            }
        }

        List<WebElement> allSearch = driver.findElements(By.xpath("//div[@role='main']//a"));
        for(WebElement each : allSearch){
            if(each.getAttribute("href").contains("Baku")){
                Thread.sleep(1000);
                each.click();
                break;
            }
        }

    }
}

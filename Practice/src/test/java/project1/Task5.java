package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

import java.util.concurrent.TimeUnit;

public class Task5 {
    String url;
    String locator;
    String verifyAfterFirstClick;
    String allLinks;
    String attribute;
    String getElement;
    WebDriver driver;

    public void getDriver(){
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(this.url);
    }

    public boolean selectElement(){
        WebElement element1 = driver.findElement(By.xpath(locator));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath(verifyAfterFirstClick));
        if(element2.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    public void selectSpecificElement(){
        List<WebElement> allLinks = driver.findElements(By.xpath(this.allLinks));
        for(WebElement each : allLinks){
            if(each.getAttribute(attribute).contains(getElement)){
                each.click();
            }
        }
    }
}

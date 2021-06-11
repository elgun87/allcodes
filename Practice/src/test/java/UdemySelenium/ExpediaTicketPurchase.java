package UdemySelenium;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
import java.util.*;

public class ExpediaTicketPurchase {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome", 15);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
        WebElement dates = driver.findElement(By.linkText("Flights"));
        dates.click();
        WebElement roundTrip = driver.findElement(By.linkText("One-way"));
        roundTrip.click();
        WebElement leavingFrom = driver.findElement(By.xpath("//button[contains(@aria-label,'Leaving')]"));
        leavingFrom.click();
        WebElement fromWhere = driver.findElement(By.xpath("//input[contains(@placeholder,'Where')]"));
        fromWhere.sendKeys("Baku");
        List<WebElement> allCity = driver.findElements(By.xpath("//ul[contains(@class,'result')]/li//div/div/span/strong"));
        for(WebElement each : allCity){
            if(each.getText().contains("Baku")){
                driver.findElement(By.xpath("//ul[contains(@class,'result')]/li//div/div[2]/../..")).click();
            }
        }
        Thread.sleep(2000);
        WebElement goingTo = driver.findElement(By.xpath("//button[contains(@aria-label,'Going')]"));
        goingTo.click();
        WebElement inputGoingTo = driver.findElement(By.xpath("//input[contains(@placeholder,'going to')]"));
        inputGoingTo.sendKeys("New York");
        List<WebElement> destination = driver.findElements(By.xpath("//div[contains(@title,'Going')]/div//div[2]//ul//li//strong"));
        System.out.println(destination.size());
        for(WebElement each : destination){
            System.out.println(each.getText());
            if(each.getText().contains("JFK")){
                each.click();
                break;
            }
        }
        Thread.sleep(2000);
        WebElement dateButton = driver.findElement(By.xpath("//div[@class='Dates']//button"));
        dateButton.click();
        List<WebElement> departureDates = driver.findElements(By.xpath("(//div[contains(@class,'picker-month')])[1]//table//tbody//td//button"));
        for(WebElement each : departureDates){
            if(each.getAttribute("data-day").equals("15")){
                each.click();
                driver.findElement(By.xpath("//button[@data-stid='apply-date-picker']")).click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Search']")).click();
    }

}

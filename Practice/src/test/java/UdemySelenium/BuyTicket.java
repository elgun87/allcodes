package UdemySelenium;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BuyTicket {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome",15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement dropDown = driver.findElement(By.id("divpaxinfo"));
        dropDown.click();
        int count = 0;
        WebElement adultClick = driver.findElement(By.id("hrefIncAdt"));
        WebElement childClick = driver.findElement(By.id("hrefIncChd"));
        WebElement infantClick = driver.findElement(By.id("hrefIncInf"));
        while(true){
            if (count < 2){
                adultClick.click();
                infantClick.click();
            }
            if(count < 4){
                childClick.click();
                if(count == 3){
                    break;
                }
            }
            count++;
        }
        WebElement doneButton = driver.findElement(By.xpath("//input[@value='Done']"));
        doneButton.click();
        WebElement info = driver.findElement(By.id("divpaxinfo"));
        System.out.println(info.getText());
        WebElement departure = driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_ddl_originStation1_CTXT'])[1]"));
        departure.click();
        WebElement chennai = driver.findElement(By.xpath("//a[@value='MAA']"));
        chennai.click();
        driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT'])")).click();
        WebElement goa = driver.findElement(By.xpath("//a[@value='GOI']"));
        goa.click();

    }
}

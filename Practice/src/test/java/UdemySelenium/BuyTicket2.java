package UdemySelenium;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuyTicket2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome", 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement departure = driver.findElement(By.xpath("(//input[@id='ctl00_mainContent_ddl_originStation1_CTXT'])[1]"));
        departure.click();
        List<String> cityValue = new ArrayList<>();
        List<WebElement> allCity = driver.findElements(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a"));
        for(WebElement each : allCity){
            each.click();
            departure.click();
        }

        Thread.sleep(3000);
        driver.close();

    }
}

package UdemySelenium;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

import java.util.concurrent.TimeUnit;

public class AutoSuggestedDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome", 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement autosuggest = driver.findElement(By.id("autosuggest"));
        autosuggest.sendKeys("as");
        List<WebElement> selectAutoSuggest = driver.findElements(By.cssSelector("ul.ui-autocomplete.ui-front.ui-menu.ui-widget.ui-widget-content.ui-corner-all a"));
        System.out.println(selectAutoSuggest.size());
        for(WebElement each : selectAutoSuggest){
            Thread.sleep(3000);
            each.click();
            break;
//            if(each.getText().equalsIgnoreCase("bahamas")){
//                each.click();
//                break;
//            }
        }
    }
}

package GurhanTask.Day9;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;

public class get50DollarCustomerStABLE {
    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver("chrome",20);
        driver.get("http://practice.cybertekschool.com/tables");
        List<WebElement> all50Customers = driver.findElements(By.xpath("//div[@class='example']//tr"));
        for(int i = 0;i < all50Customers.size();i++){
            if(all50Customers.get(i).getText().contains("50.")){
                String names [] = all50Customers.get(i).getText().split(" ");
                BroweserUtils.sleep(5);
                System.out.println(names[0] + " " + names[1]);
            }
        }


    }
}

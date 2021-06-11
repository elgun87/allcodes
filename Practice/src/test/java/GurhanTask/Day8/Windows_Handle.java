package GurhanTask.Day8;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Windows_Handle {
    WebDriver driver;
    @BeforeClass
    public void setDriver(){
        driver = Driver.getDriver("chrome",10);
        String url = "https://www.amazon.com/";
        driver.get(url);
    }
    @Test
    public void test1(){
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
//        for(String each: driver.getWindowHandles()){
//            driver.switchTo().window(each);
//            if(driver.getTitle().contains("Etsy")){
//                break;
//            }
//        }
//        Assert.assertTrue(driver.getTitle().contains("Etsy"));
        for(int i = 0;i < driver.getWindowHandles().size();i++){
            driver.switchTo().window(driver.getWindowHandle());
            System.out.println(driver.getWindowHandle().charAt(i));
        }
    }
}
// CDwindow-8E8D49101E7B931250C1F1490426E754
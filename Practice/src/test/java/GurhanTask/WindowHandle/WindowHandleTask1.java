package GurhanTask.WindowHandle;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowHandleTask1 {
    WebDriver driver;
    @BeforeClass
    public void setDriver(){
         driver = Driver.getDriver("chrome",10);
         String url = "http://practice.cybertekschool.com/windows";
         driver.get(url);
    }
    @Test
    public void test1(){
        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();
        switchWindows("New Window");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"New Window");
    }
    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
        switchWindows("Practice");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice");
    }
    public void switchWindows(String windowTitle){
        for(String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            if(driver.getTitle().equals(windowTitle)){
                break;
            }
        }
    }

}

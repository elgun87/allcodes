package GurhanTask.Iframe;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class IframePractice {
    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = Driver.getDriver("chrome",20);
        String url = "http://practice.cybertekschool.com/iframe";
        driver.get(url);
    }
    @Test
    public void test1(){
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement p = driver.findElement(By.tagName("p"));
        Assert.assertEquals(p.getText(),"Your content goes here.");
        driver.switchTo().defaultContent();
    }
    @Test
    public void test2(){
        WebElement h3 = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(h3.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

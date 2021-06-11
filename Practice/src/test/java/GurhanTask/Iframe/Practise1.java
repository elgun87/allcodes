package GurhanTask.Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practise1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.driver.chromedriver","C:\\Users\\Elgun\\IdeaProjects\\Practice\\chromedriver.exe");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/iframe");
    }

    @Test
    public void testIframe(){
//        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@title,'Text')]"));
        driver.switchTo().frame(0);
        WebElement p = driver.findElement(By.xpath("//p"));
        System.out.println(p.getText());


    }
}

package GurhanTask.Day9;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;
public class LibraryLinkVer {
    String links;
    String btnLctr;
    WebDriver driver;
    WebElement usrLgn;
    WebElement pswLctr;



    {
        driver = Driver.getDriver("chrome",20);
        driver.get("http://library2.cybertekschool.com/login.html");
        usrLgn = driver.findElement(By.id("inputEmail"));
        pswLctr = driver.findElement(By.id("inputPassword"));
        links = "//body//a";
        btnLctr = "//button[.='Sign in']";
    }



    public void logInToLibrary(String userName,String password) throws InterruptedException {
        usrLgn.sendKeys(userName);
        Thread.sleep(1000);
        pswLctr.sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnLctr)).click();
        Thread.sleep(2000);
        List<WebElement> linksAll = driver.findElements(By.xpath(links));
        System.out.println(linksAll.size());
        for(WebElement each : linksAll){
            System.out.println(each.getText());
        }
        Thread.sleep(3000);
    }
    public void close(){
        driver.close();
    }
}

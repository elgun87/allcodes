package AssigmentsSofSkills;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

import javax.swing.*;

public class VyTrack {
    protected String url;
    protected String userName;
    protected String password;
    protected String logInButton;
    protected String userNameLocator;
    protected String passwordLocator;
    protected String fleet;
    protected String vehicles;
    protected String allLinksLocator;
    protected String title;
    protected List<WebElement> allLinks;
    protected WebDriver driver;

    public void setDriver(){
        driver = Driver.getDriver("chrome",20);
        driver.get(url);
    }

    public void userLogIn() throws InterruptedException {
        WebElement usrLog = driver.findElement(By.id(userNameLocator));
        usrLog.sendKeys(userName);
        WebElement psw = driver.findElement(By.id(passwordLocator));
        psw.sendKeys(password);
        WebElement lcbtn = driver.findElement(By.id(logInButton));
        lcbtn.click();
        Thread.sleep(3000);
        title = driver.getTitle();
    }
    public void vehicleList(String clickAllElement) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(fleet))).click().build().perform();
        WebElement vehichlesClick = driver.findElement(By.xpath(vehicles));
        Thread.sleep(2000);
        vehichlesClick.click();
        Thread.sleep(2000);
        allLinks = driver.findElements(By.xpath(allLinksLocator));
        if(clickAllElement.equals("yes")){
            for(int i = 0;i < allLinks.size();i++){
                String num = String.valueOf(i+1);
                String xpath = allLinksLocator + "[]";
                xpath = xpath.substring(0,xpath.indexOf("tr") + 3) + num + xpath.substring(xpath.lastIndexOf("]"));
                WebElement element = driver.findElement(By.xpath(xpath));
                element.click();
                Thread.sleep(3000);
                driver.navigate().back();
                Thread.sleep(3000);
            }
            title = driver.getTitle();
        }
    }
    public WebDriver getMeCurrentDriver(){
        return driver;
    }
}

// #prependedInput
// #prependedInput2
 // //tbody[@class='grid-body']/tr
package GurhanTask.WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WindowHandlePractice {
    String url;
    String locator;
    String title1;
    WebDriver driver;

    public void getDrive(int delay){
        driver = new ChromeDriver();
        System.setProperty("webdriver.driver.chromedriver","C:\\Users\\Elgun\\IdeaProjects\\Practice\\chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(delay, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(this.url);
    }

    public String checkTitle(){
        String title = driver.getTitle();
        return title;
    }

    public boolean checkNextWindow(String window,String expected){
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
        String actual = getNextWindow(window);
        if(actual.equals(expected)){
            return true;
        }else{
            return false;
        }
    }

    public String getNextWindow(String window){
        for(String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            if(driver.getTitle().equals(window)){
                break;
            }
        }
        String actualTitle = driver.getTitle();
        return actualTitle;
    }
    public void closeBrowser(){
        driver.close();
    }
}

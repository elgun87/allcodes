package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    public static WebDriver getDriver(String selectDriver,int delay){
        if(selectDriver.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(delay, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            System.setProperty("webdriver.driver.chromedriver","C:\\Users\\Elgun\\IdeaProjects\\Practice\\chromedriver.exe");
        }
        return driver;
    }
}

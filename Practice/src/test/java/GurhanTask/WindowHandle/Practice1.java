package GurhanTask.WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.driver.chromedriver","C:\\Users\\Elgun\\IdeaProjects\\Practice\\chromedriver.exe");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    @Test
    public void window_test(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        WebElement link = driver.findElement(By.xpath("//a[.='Click Here']"));
        link.click();

        getWindow("New Window");

        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        getWindow("Practice");

        System.out.println(driver.findElement(By.xpath("//h3")).getText());
    }

    public void getWindow(String getMeThisWindow){
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(getMeThisWindow)){
                break;
            }
        }
    }
}

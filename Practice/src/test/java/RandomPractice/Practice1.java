package RandomPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.driver.chromedriver","C:\\Users\\Elgun\\IdeaProjects\\Practice\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        WebElement element = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul"));
        System.out.print(element.getText());
    }
}

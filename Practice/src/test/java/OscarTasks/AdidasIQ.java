package OscarTasks;

import Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdidasIQ {

    WebDriver driver;
    String currentUrl = "https://www.demoblaze.com/index.html";

    @BeforeClass
    public void setDriver() {
        driver = Driver.getDriver("chrome", 30);
        String url = "https://www.demoblaze.com/index.html";
        driver.get(url);
    }

    @Test
    public void test1() throws InterruptedException {
        String locator1 = "//div[@class='list-group']//a[.='Laptops']";
        String locator2 = "Sony vaio i5";
        String addToCart = "Add to cart";
        String cart = "Cart";
        selectItem(driver, locator1, locator2, addToCart, cart, currentUrl);
    }

    @Test
    public void test2() throws InterruptedException {
        String locator1 = "//div[@class='list-group']//a[.='Phones']";
        String locator2 = "Samsung galaxy s6";
        String addToCart = "Add to cart";
        String cart = "Cart";
        selectItem(driver, locator1, locator2, addToCart, cart, currentUrl);

    }

    @Test
    public void test3() throws InterruptedException {
        String locator1 = "//div[@class='list-group']//a[.='Monitors']";
        String locator2 = "Apple monitor 24";
        String addToCart = "Add to cart";
        String cart = "Cart";
        selectItem(driver, locator1, locator2, addToCart, cart, currentUrl);

    }

    @Test
    public void test4() throws InterruptedException {
        WebElement cart = driver.findElement(By.linkText("Cart"));
        cart.click();
        Thread.sleep(2000);
        List<WebElement> allItems = driver.findElements(By.xpath("//tbody[@id='tbodyid']//tr"));
        int index = 1;
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getText().contains("Apple")) {
                i += 1;
                index = i;
                System.out.println(i);
                break;
            }
        }
        String str = "//tbody[@id='tbodyid']//tr['" + index + "']//a";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                str = str.substring(0, i - 1) + str.substring(i).replace("'", "");
            }
        }
        WebElement delete = driver.findElement(By.xpath(str));
        delete.click();
        Thread.sleep(2000);
    }

    @Test
    public void test5() throws InterruptedException {
        if (!driver.getCurrentUrl().equals("https://www.demoblaze.com/cart.html")) {
            driver.navigate().to("https://www.demoblaze.com/cart.html");
        }
        WebElement button = driver.findElement(By.xpath("//button[.='Place Order']"));
        button.click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@id='orderModal']"));
        if(element.isDisplayed()){
            Faker faker = new Faker();
            String fullName = faker.name().fullName();
            String country = faker.country().name();
            String city = faker.country().capital();
            String creditCard = faker.finance().creditCard();
            String date = faker.date().toString();
            String locatorAllInputes = "//div[@id='orderModal']/div/div/div/following-sibling::div/form//div//input";
            List<String> userInputes = new ArrayList<>(Arrays.asList(fullName,country,city,creditCard,date,"2021"));
            List<String> attrValues = new ArrayList<>(Arrays.asList("name","country","city","card","month","year"));
            //TODO Below method automatically adds all user inputes
            sendInput(driver,locatorAllInputes,attrValues,userInputes);
        }
        driver.findElement(By.xpath("//button[.='Purchase']")).click();
    }


    public void selectItem(WebDriver driver, String locator, String locator2, String locator3, String locator4, String currentUrl) throws InterruptedException {
        if (!driver.getCurrentUrl().equals(currentUrl)) {
            driver.navigate().to(currentUrl);
        }
        WebElement laptops = driver.findElement(By.xpath(locator));
        laptops.click();
        Thread.sleep(2000);
        WebElement item = driver.findElement(By.linkText(locator2));
        item.click();
        Thread.sleep(2000);
        WebElement addToCart = driver.findElement(By.linkText(locator3));
        addToCart.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

    }



    public void sendInput(WebDriver driver,String locatorAllInputes,List<String> attrValue,List<String> userInput){
        List<WebElement> allInputes = driver.findElements(By.xpath(locatorAllInputes));
        System.out.println(allInputes.size());
        for(int i = 0;i < allInputes.size();i++){
            System.out.println(allInputes.get(i).getAttribute("id"));
            if(allInputes.get(i).getAttribute("id").equals(attrValue.get(i))){
                allInputes.get(i).sendKeys(userInput.get(i));
            }
        }
    }
}

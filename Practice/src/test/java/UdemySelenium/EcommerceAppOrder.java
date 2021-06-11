package UdemySelenium;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class EcommerceAppOrder {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver("chrome",20);
        String url = "https://rahulshettyacademy.com/seleniumPractise/#/";
        driver.get(url);
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello Welcome to GreenKart Online Grocery Store");
        System.out.println("Would you like shop grocery today?");
        String confirm = scan.next();
        if(confirm.equals("y")){
            System.out.println("Please enter the product name:");
            String product = scan.next();
            System.out.println("Please enter quantity:");
            int quantity = scan.nextInt();
            addGroceryToCart(product,driver,quantity);
            while (true){
                System.out.println("add more grocery?");
                confirm = scan.next();
                if (confirm.equals("y")){
                    System.out.println("Please enter the product name:");
                    product = scan.next();
                    System.out.println("Please enter quantity:");
                    quantity = scan.nextInt();
                    addGroceryToCart(product,driver,quantity);
                }else{
                    System.out.println("Directing you to cart");
                    WebElement cart = driver.findElement(By.xpath("//a[@class='cart-icon']"));
                    Thread.sleep(2000);
                    cart.click();
                    WebElement checkout = driver.findElement(By.xpath("//button[.='PROCEED TO CHECKOUT']"));
                    Thread.sleep(2000);
                    checkout.click();
                    WebElement placeOrder = driver.findElement(By.xpath("//button[.='Place Order']"));
                    Thread.sleep(2000);
                    placeOrder.click();
                    WebElement selectCountry = driver.findElement(By.tagName("select"));
                    Select select = new Select(selectCountry);
                    select.selectByVisibleText("United States");
                    driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//button[.='Proceed']")).click();
                    System.out.println("Thanks for shopping with us.Come back again");
                    break;
                }
            }
        }
    }
    public static void addGroceryToCart(String grocery,WebDriver driver,int count) throws InterruptedException {
        List<WebElement> groceryList = driver.findElements(By.xpath("//div[@class='products']/div/h4"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for(int i = 0;i < groceryList.size();i++){
            if(groceryList.get(i).getText().contains(grocery)){
                String index = String.valueOf(i+1);
                String xpath = "//div[@class='products']/div["+index+"]";
                WebElement elemen2 = driver.findElement(By.xpath(xpath));
                Actions action = new Actions(driver);
                action.moveToElement(elemen2).perform();
                if(count > 0){
                    while (count != 1){
                        String xpath2 = "//div[@class='products']/div["+index+"]/div[2]/a[2]";
                        WebElement quantity = driver.findElement(By.xpath(xpath2));
                        Thread.sleep(2000);
                        quantity.click();
                        count--;
                    }
                }
                WebElement element = driver.findElement(By.xpath("//div[@class='products']/div["+index+"]/div[3]"));
                element.click();
                break;
            }
        }
    }
}

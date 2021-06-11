package GurhanTask.Day8.smartBearTask;

import GurhanTask.Day8.customerSmartBear.CustomerSB;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SmartBear {
    String url;String userNameLocator;String passWordLocator;String loginButton;String orderLocator;
    String selectLocator;String quantity;String quantityLocator;String calcLocator;List<String> userInputes;
    List<String> inputesId;String card;String cardNr;String date;String proccesButton;private WebDriver driver;
    String allCustomerLctr;String info;String nameFromTAble;List<CustomerSB> smartBearCustInfo;List<WebElement> elements;
    List<String> givenCusInfo = new ArrayList<>();

    public void getDriverAndUrl(int delayTime) {
        driver = Driver.getDriver("chrome", delayTime);
        driver.get(url);
    }
    public int userNameAndPassword(String userName, String password, String allLinks) {
        WebElement userNameInput = driver.findElement(By.id(userNameLocator));
        userNameInput.sendKeys(userName);
        WebElement passwordInput = driver.findElement(By.id(passWordLocator));
        passwordInput.sendKeys(password);
        WebElement login = driver.findElement(By.id(loginButton));
        login.click();
        List<WebElement> allInks = driver.findElements(By.tagName(allLinks));
        System.out.println(driver.getTitle());
        for (WebElement each : allInks) {
            System.out.println(each.getText());
        }
        System.out.println("==============================================================");
        return allInks.size();
    }
    // insert user info
    public void order(String userName, String password, String allLinks, String myFamily) {
        userNameAndPassword(userName, password, allLinks);
        WebElement orderButton = driver.findElement(By.linkText(orderLocator));
        orderButton.click();
        WebElement selectItem = driver.findElement(By.xpath(selectLocator));
        Select select = new Select(selectItem);
        select.selectByVisibleText(myFamily);
        WebElement element1 = driver.findElement(By.id(quantityLocator));
        element1.sendKeys(quantity);
        WebElement element2 = driver.findElement(By.xpath(calcLocator));
        element2.click();
    }
    //insert user adress info
    public void addresInfo(String getAllInputes) {
        List<WebElement> allInputes = driver.findElements(By.xpath(getAllInputes));
        for (int i = 0; i < allInputes.size(); i++) {
            if (allInputes.get(i).getAttribute("id").contains(inputesId.get(i))) {
                allInputes.get(i).sendKeys(userInputes.get(i));
            }
        }
    }
    //insert payment info
    public String payment(String fakeCardNr, String fakeDate) {
        WebElement element = driver.findElement(By.id(card));
        element.click();
        WebElement element2 = driver.findElement(By.id(cardNr));
        element2.sendKeys(fakeCardNr);
        WebElement element3 = driver.findElement(By.id(date));
        element3.sendKeys(fakeDate);
        WebElement element4 = driver.findElement(By.id(proccesButton));
        element4.click();
        WebElement element5 = driver.findElement(By.tagName("strong"));
        return element5.getText();

    }
    //Look for user from the tabel
    public void verifyCustomer(String customerName)  {
        List<WebElement> customers = driver.findElements(By.xpath(allCustomerLctr));
        for(int i = 1;i < customers.size();i++){
            String index = String.valueOf(i+1);
            List<WebElement> customerInfo = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+ index +"]//td"));
            for(int j = 1;j < customerInfo.size();j++){
                if(customerInfo.get(j).getText().equalsIgnoreCase(customerName)){
                    nameFromTAble = customerInfo.get(j).getText();
                    elements = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+ index +"]//td"));
                    for (int m = 0; m < elements.size();m++){
                        if(elements.get(m).getText().length() > 1){
                            //TODO ADDING GIVEN CUSTOMER INFO TO LIST
                            givenCusInfo.add(elements.get(m).getText());
                        }
                    }
                }
            }
        }
    }
    public void printCustomerInfo(){
        //TODO THIS METHOD IS CREATING CustomerSB TYPE OBJECT AND ASSIGN ALL VALUES TO IT
        CustomerSB customer = new CustomerSB();
        customer.name = givenCusInfo.get(0);
        customer.product = givenCusInfo.get(1);
        customer.orderDate = givenCusInfo.get(2);
        customer.street = givenCusInfo.get(3);
        customer.city = givenCusInfo.get(4);
        customer.state = givenCusInfo.get(5);
        customer.zip = givenCusInfo.get(6);
        customer.card = givenCusInfo.get(7);
        customer.cardNumber = givenCusInfo.get(8);
        customer.expDate = givenCusInfo.get(9);
        smartBearCustInfo = new ArrayList<>();
        smartBearCustInfo.add(customer);
        for(CustomerSB customerSB : smartBearCustInfo){
            System.out.println("Customer name = " + customer.name);
            System.out.println("Customer product = " + customer.product);
            System.out.println("Customer expDate = " + customer.expDate);
            System.out.println("Customer street = " + customer.street);
            System.out.println("Customer city = " + customer.city);
            System.out.println("Customer state = " + customer.state);
            System.out.println("Customer zip = " + customer.zip);
            System.out.println("Customer card = " + customer.card);
            System.out.println("Customer cardNumber = " + customer.cardNumber);
            System.out.println("Customer expDate = " + customer.expDate);
        }
    }
//    public void closeDriver() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.close();
//    }
}

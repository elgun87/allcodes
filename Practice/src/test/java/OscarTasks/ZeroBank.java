package OscarTasks;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.*;

public class ZeroBank {
    WebDriver driver;
    String actualTitle;
    String expectedTitle;
    List<WebElement> actualDropDowns;

    @BeforeClass
    public void setUp() {
        //1. The user navigates to the login page: http://zero.webappsecurity.com/login.html
        driver = Driver.getDriver("chrome", 20);
        String url = "http://zero.webappsecurity.com/login.html";
        driver.get(url);
        actualTitle = driver.getTitle();
    }

    @Test
    public void test1() {

        if (actualTitle != null) {
            expectedTitle = "Zero - Log in";
            Assert.assertEquals(actualTitle, expectedTitle);
        }
    }

    @Test
    public void test2() {
        //2. The user logs in with the user "username" and the password "password"
        WebElement login = driver.findElement(By.xpath("//input[@name='user_login']"));
        login.sendKeys("username");
        WebElement password = driver.findElement(By.xpath("//input[@name='user_password']"));
        password.sendKeys("password");
        WebElement signIn = driver.findElement(By.xpath("//input[@value='Sign in']"));
        signIn.click();
        actualTitle = driver.getTitle();
        if (actualTitle.equals("Privacy error")) {
            WebElement backToSafety = driver.findElement(By.xpath("//button[.='Back to safety']"));
            backToSafety.click();
            actualTitle = driver.getTitle();
            expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
            Assert.assertEquals(expectedTitle, actualTitle);
        }
    }

    @Test
    public void test3() {
        //3. The user navigates to Account Activity page
        //4. Then The page should have the title "Zero - Account Activity"
        WebElement activity = driver.findElement(By.xpath("//span[contains(@id,'activity')]"));
        activity.click();
        expectedTitle = "Zero - Account Activity";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void test4() {
        //5. Then Account drop down should have the following options :
        // (Savings, Checking, Savings, Loan, Credit Card, Brokerage)
        boolean verifyAllDropDowns = true;
        String expectedDropDowns[] = {"Savings", "Checking", "Savings", "Loan", "Credit Card", "Brokerage"};
        WebElement account = driver.findElement(By.xpath("//select[@id='aa_accountId']"));
        Select select = new Select(account);
        actualDropDowns = select.getOptions();
        for (int i = 0; i < expectedDropDowns.length; i++) {
            if (!actualDropDowns.get(i).getText().equals(expectedDropDowns[i])) {
                verifyAllDropDowns = false;
            }
        }
        Assert.assertTrue(verifyAllDropDowns);
    }
    @Test
    public void test6(){
        //6. Brokerage option should have "No results."
        for(WebElement each : actualDropDowns){
            if(each.getText().equals("Brokerage")){
                each.click();
            }
        }
        WebElement brokerAge = driver.findElement(By.xpath("//div[@class='well']"));
        expectedTitle = "No results.";
        actualTitle = brokerAge.getText().trim();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}

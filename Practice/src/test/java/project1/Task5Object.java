package project1;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task5Object {
    Task5 object = new Task5();
    @BeforeMethod
    public void setDriver(){
        object.url = "http://practice.cybertekschool.com/dropdown";
        object.getDriver();
    }

    @Test
    public void test1(){
        object.locator = "//a[@id='dropdownMenuLink']";
        object.verifyAfterFirstClick = "//div[@class='dropdown-menu show']";
        Assert.assertTrue(object.selectElement());
    }
}

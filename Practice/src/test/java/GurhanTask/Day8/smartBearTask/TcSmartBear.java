package GurhanTask.Day8.smartBearTask;

import GurhanTask.Day8.smartBearTask.SmartBear;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TcSmartBear {

    SmartBear bear;
    @BeforeClass
    public void setDriver(){
        bear = new SmartBear();
        bear.url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        bear.getDriverAndUrl(20);
    }
    @Test
    public void test1(){
        bear.userNameLocator = "ctl00_MainContent_username";
        bear.passWordLocator = "ctl00_MainContent_password";
        bear.loginButton = "ctl00_MainContent_login_button";
        int actual = bear.userNameAndPassword("Tester","test","a");
        Assert.assertEquals(actual,6);
    }
    @Test
    public void test2()  {
        bear.allCustomerLctr = "//table[@id='ctl00_MainContent_orderGrid']//tr";
        String expected = "Paul Brown";
        bear.verifyCustomer(expected);
        Assert.assertEquals(expected,bear.nameFromTAble);

        //TODO BELOW METHOD WILL CREATE NEW OBJECT AND GIVEN CUSTOMER INFO TO THAT OBJECT THEN PRINT ALL INFO
        bear.printCustomerInfo();
    }
//    @AfterMethod
//    public void tearDown() throws InterruptedException {
//        bear.closeDriver();
//    }
}

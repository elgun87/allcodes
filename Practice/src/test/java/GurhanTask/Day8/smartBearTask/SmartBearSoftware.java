package GurhanTask.Day8.smartBearTask;
import GurhanTask.Day8.smartBearTask.SmartBear;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SmartBearSoftware {
    SmartBear bear;
    Faker faker;
    @BeforeClass
    public void setUp(){
        bear = new SmartBear();
        bear.url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
        bear.getDriverAndUrl(20);
    }
    @Test
    public void test1(){
        //set username
        bear.userNameLocator = "ctl00_MainContent_username";
        bear.passWordLocator = "ctl00_MainContent_password";
        bear.loginButton = "ctl00_MainContent_login_button";
        bear.orderLocator = "Order";
        bear.selectLocator = "//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']";
        bear.quantityLocator = "ctl00_MainContent_fmwOrder_txtQuantity";
        bear.quantity = "2";
        bear.calcLocator = "//input[@value='Calculate']";
        bear.order("Tester","test","a","FamilyAlbum");
        bear.inputesId = Arrays.asList("Name","Box2", "Box3","Box4","Box5");
        faker = new Faker();
        String name = faker.funnyName().name();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipcode = faker.address().zipCode().replace("-","");
        bear.userInputes = Arrays.asList(name,street,city,state,zipcode);
        bear.addresInfo("//div[@class='content']/table/tbody/tr/td/ol[2]//input");
        bear.card = "ctl00_MainContent_fmwOrder_cardList_0";
        bear.cardNr = "ctl00_MainContent_fmwOrder_TextBox6";
        bear.date = "ctl00_MainContent_fmwOrder_TextBox1";
        String cardNumber = faker.finance().creditCard().replace("-","");
        String date = "09/23";
        bear.proccesButton = "ctl00_MainContent_fmwOrder_InsertButton";
        String actual = bear.payment(cardNumber,date).trim();
        String expected = "New order has been successfully added.";
        Assert.assertEquals(actual,expected);
    }

}



package AssigmentsSofSkills;

import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;

public class VyTrakTest {
    VyTrack truckDriver;
    @BeforeClass
    public void setDriver(){
        truckDriver = new VyTrack();
        truckDriver.url = "https://qa3.vytrack.com/user/login";
        truckDriver.setDriver();
    }
    @Test
    public void test1() throws InterruptedException {
        truckDriver.userNameLocator = "prependedInput";
        truckDriver.userName = ConfigReader.getProperty("username");
        truckDriver.passwordLocator = "prependedInput2";
        truckDriver.password = ConfigReader.getProperty("password");
        truckDriver.logInButton = "_submit";
        truckDriver.userLogIn();
        String actuall = truckDriver.title;
        String expected = ConfigReader.getProperty("titleDashboard");
        Assert.assertEquals(actuall,expected);

    }
    @Test
    public void test2() throws InterruptedException {
        truckDriver.fleet = "//a[@class='unclickable']";
        truckDriver.vehicles = "//a[@class='unclickable']/following-sibling::div/div/ul/li[3]/a";
        truckDriver.allLinksLocator = "//tbody[@class='grid-body']/tr";
        truckDriver.vehicleList("yes");
        String actual = truckDriver.title;
        String expected = ConfigReader.getProperty("titleVehicles");
        Assert.assertEquals(actual,expected);
    }

}

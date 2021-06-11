package AssigmentsSofSkills;

import Utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetLocationVyTrack extends VyTrack {
    public static void main(String[] args) throws InterruptedException {
        GetLocationVyTrack object = new GetLocationVyTrack();
        object.url = "https://qa3.vytrack.com/user/login";
        object.setDriver();
        object.userNameLocator = "prependedInput";
        object.passwordLocator = "prependedInput2";
        object.userName = ConfigReader.getProperty("username");
        object.password = ConfigReader.getProperty("password");
        object.logInButton = "_submit";
        object.userLogIn();
        object.fleet = "//a[@class='unclickable']";
        object.vehicles = "//a[@class='unclickable']/following-sibling::div/div/ul/li[3]/a";
        object.allLinksLocator = "//tbody[@class='grid-body']/tr";
        object.vehicleList("no");
        WebDriver driver = object.getMeCurrentDriver();


        for(int i = 0;i < object.allLinks.size();i++){
            WebElement location = driver.findElement(By.xpath("//tbody//tr[" + (i+1) + "]/td[4]"));
            if(location.getText().equals("Texas")){
                location.click();
                Thread.sleep(2000);
                System.out.println(driver.getTitle());
            }
        }
    }
}
 // //tbody//tr/td[3]
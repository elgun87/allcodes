package GurhanTask.WindowHandle;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandlePracticeTest {
    WindowHandlePractice object = new WindowHandlePractice();
    @BeforeMethod
    public void setDrive(){
        object.url = "http://practice.cybertekschool.com/windows";
        object.getDrive(20);
    }

    @Test
    public void test1(){
        object.title1 = "Practice";
        String actual = object.checkTitle();
        Assert.assertEquals(actual,object.title1);
    }

    @Test
    public void test2(){
        object.locator = "//a[.='Click Here']";
        boolean checkWindow = object.checkNextWindow("New Window","New Window");
        Assert.assertTrue(checkWindow);
    }
    @AfterMethod
    public void tearDown(){
        object.closeBrowser();
    }
}

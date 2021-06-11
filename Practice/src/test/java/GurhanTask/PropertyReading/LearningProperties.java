package GurhanTask.PropertyReading;

import Utilities.ConfigReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LearningProperties {
    @Test
    public void property_test()  {

        System.out.println( ConfigReader.getProperty("browser"));
    }
}

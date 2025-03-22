package config;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void takeScreenshot(WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = "./target/screenshots/" + "foto" + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
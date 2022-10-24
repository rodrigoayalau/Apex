package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

import static base.DriverFactory.driver;
import static base.DriverFactory.getDriver;

public class Utils {
    public static void takeScreenShot(Object getClass) throws IOException {
        File evidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(evidence, new File("src/test/screenshots/" + getClass + ".png"));
    }
    public static void takeScreenShot(String testEvidence) throws IOException {
        File evidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(evidence, new File("src/test/screenshots/" + testEvidence + ".png"));
    }

    public static void coloredElement(WebElement el){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", el);
    }
}

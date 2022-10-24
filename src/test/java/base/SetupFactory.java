package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static base.DriverFactory.getDriver;

public class SetupFactory {
    WebDriver driver;

    @BeforeSuite
    public void setUp() throws IOException {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.liverpool.com.mx/tienda/home");
    }

    @AfterSuite(enabled = false)
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}

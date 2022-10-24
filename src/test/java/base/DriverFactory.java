package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    public static WebDriver driver;
    public static WebDriverWait wait;
    final static String browser = "chrome_manager";

    public static WebDriver getDriver(){
        if(driver == null){
            switch (browser) {
                case "chrome" -> {
                    System.setProperty("webdriver.chrome.driver", "C:/explorers_drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    System.setProperty("webdriver.gecko.driver", "C:/drivers_explorers/geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                case "chrome_manager" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                default -> {
                    System.setProperty("webdriver.edge.driver", "C:/drivers_explorers/msedgedriver.exe");
                    driver = new EdgeDriver();
                }
            }
        }
        return driver;
    }
}

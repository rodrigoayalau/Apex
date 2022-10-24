package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static base.DriverFactory.getDriver;

public class LoginPage {

    WebDriver driver = getDriver();
    WebDriverWait wait;

    private LoginPage() {
    }

    public static LoginPage getLogginPage() {
        return new LoginPage();
    }

    private final By emailInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By logginButton = By.xpath("/html/body/code/main/section/div/div/div/form/div[2]/button");

    public LoginPage loggin(String email, String password){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement emailElement = driver.findElement(emailInput);
        WebElement passwordElement = driver.findElement(passwordInput);
        WebElement logginElement = driver.findElement(logginButton);
        emailElement.click();
        emailElement.clear();
        emailElement.sendKeys(email);
        passwordElement.click();
        passwordElement.clear();
        passwordElement.sendKeys(password);
        logginElement.click();
        return this;
    }
}

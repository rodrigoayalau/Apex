package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static base.DriverFactory.getDriver;

public class CartPage {

    WebDriver driver = getDriver();
    WebDriverWait wait;

    private CartPage(){}

    public static CartPage getCartPage(){
        return new CartPage();
    }

    private final By cartLink = By.className("a-header__bag");
    private final By myBag = By.className("o-myBag");
    private final By sellButton = By.xpath("//button[@class='a-btn a-btn--primary a-product__buttonBuy']");

    public CartPage goToCartPage(){
        WebElement cartElement = driver.findElement(cartLink);
        cartElement.click();
        return this;
    }

    public CartPage validateItems(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> myBagElements = driver.findElements(myBag);
        WebElement sellButtonElement = driver.findElement(sellButton);
        if(myBagElements.size() > 0){
            sellButtonElement.click();
        }
        return this;
    }
}

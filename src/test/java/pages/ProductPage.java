package pages;

import base.SetupFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static base.DriverFactory.getDriver;

public class ProductPage extends SetupFactory {

    WebDriver driver = getDriver();
    WebDriverWait wait;

    private ProductPage() {
    }

    public static ProductPage getProductPage() {
        return new ProductPage();
    }

    @FindBy(how= How.CLASS_NAME, using = "a-product__information--title")
    WebElement mainItemTitle;

    private final By itemTitle = By.xpath("//div[@class='o-product__description']//child::h1");
    private final By sellButton = By.id("opc_pdp_buyNowButton");
    private final By addToMyCartButton = By.id("opc_pdp_addCartButton");

    public ProductPage validateItemTitle(String itemName) {
        wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.textToBe(itemTitle, itemName));
        return this;
    }

    public ProductPage validateItemTitle2(String itemName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement titleElement = driver.findElement(itemTitle);
        String titleText = titleElement.getText();
        if(titleText.equals(itemName)){
            System.out.println("Is equal");
        }
        return this;
    }

    public ProductPage clickSellNowButton() {
        WebElement buttonElement = driver.findElement(sellButton);
        buttonElement.click();
        return this;
    }

    public ProductPage clickAddToMyCartButton(){
        WebElement buttonElement = driver.findElement(addToMyCartButton);
        buttonElement.click();
        return this;

    }
}

package test;

import base.SetupFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static base.DriverFactory.getDriver;
import static pages.CartPage.getCartPage;
import static pages.LoginPage.getLogginPage;
import static pages.ProductPage.getProductPage;
import static utils.Utils.takeScreenShot;

public class BuyAProductTest extends SetupFactory {

    ProductPage productPage = getProductPage();
    LoginPage loggin = getLogginPage();

    CartPage cart = getCartPage();

    Properties prop = new Properties();
    String propFile;

    String searchItem;
    String elementCode;
    String productItem;
    String email;
    String password;

    String fullClassName = getClass().getSimpleName();

    @BeforeClass
    public void initializeTest() throws IOException {
        propFile = "src/test/java/resources/" + getClass().getSimpleName() + ".properties";
        prop.load(new FileInputStream(new File(propFile)));
        searchItem = prop.getProperty("data.item");
        elementCode = prop.getProperty("data.tv");
        productItem = prop.getProperty("data.product");
        email = prop.getProperty("data.email");
        password = prop.getProperty("data.password");
    }

    @Test(priority = 1)
    public void searchForItem() throws IOException {
        HomePage home = new HomePage(getDriver());
        Assert.assertTrue(home.searchItem(searchItem), "Failed trying to search for element.");
        Assert.assertTrue(home.validateSearchContext(), "Failed trying to validate suggestion box.");
        takeScreenShot(getClass().getSimpleName());
        Assert.assertTrue(home.giveEnterInSearchBox(), "Failed trying to click enter.");
    }

    @Test(priority = 2)
    public void selectItem() {
        ProductsPage product = new ProductsPage(getDriver());
        Assert.assertTrue(product.retrieveElement(elementCode), "Fail trying to select the TV.");
    }

    @Test(priority = 3)
    public void buySelectedItem() throws IOException {
        productPage.validateItemTitle(productItem).clickAddToMyCartButton();
        takeScreenShot("ClickingSell");
    }

    @Test(priority = 4)
    public void validateCart(){
        cart.goToCartPage().validateItems();
    }

    @Test(priority = 5)
    public void loggin() {
        loggin.loggin(email, password);
    }


    @Test(priority = 6)
    @Parameters({"val1", "val2"})
    public void parametrizationTest(int n1, int n2) {
        int finalResult = n1 + n2;
        System.out.println(finalResult);
    }

}

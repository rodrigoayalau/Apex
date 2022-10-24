package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static base.DriverFactory.getDriver;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(how= How.XPATH, using = "//li[@class='m-product__card card-masonry a']//child::a"))
    List<WebElement> itemsList;

    public boolean retrieveElement(String elementCode){
        wait = new WebDriverWait(getDriver(), 10);
        boolean itPassed;
        try{
            wait.until(ExpectedConditions.visibilityOfAllElements(itemsList));
            for(WebElement element : itemsList){
                System.out.println("TVs: " + element.getText());
                if(element.getText().contains(elementCode)){
                    element.click();
                    break;
                }
            }
            itPassed = true;
        } catch (Exception e) {
            e.printStackTrace();
            itPassed = false;
        }
        return itPassed;
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.DriverFactory.getDriver;
import static utils.Utils.coloredElement;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By SearchBarInput = By.id("mainSearchbar");
    private final By SearchContextContainer = By.xpath("//div[@class='m-typeahead']");


    /**
     * Search searchItem
     *
     * @param item string item from properties file.
     */
    public boolean searchItem(String item){
        boolean itPassed;
        try{
            WebElement searchBarElement = driver.findElement(SearchBarInput);
            searchBarElement.click();
            searchBarElement.clear();
            searchBarElement.sendKeys(item);
            coloredElement(searchBarElement);
            itPassed = true;
        } catch (Exception e) {
            e.printStackTrace();
            itPassed = false;
        }
        return itPassed;
    }

    /**
     * validateSearchContext
     *
     */
    public boolean validateSearchContext(){
        boolean itPassed;
        try{
            WebElement searchContextElement = driver.findElement(SearchContextContainer);
            wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.visibilityOf(searchContextElement));
            itPassed = true;
        } catch (Exception e) {
            e.printStackTrace();
            itPassed = false;
        }
        return itPassed;
    }


    /**
     * giveEnterInSearchBox
     *
     */
    public boolean giveEnterInSearchBox(){
        boolean itPassed;
        try{
            WebElement searchBarElement = driver.findElement(SearchBarInput);
            searchBarElement.sendKeys(Keys.ENTER);
            itPassed = true;
        } catch (Exception e) {
            e.printStackTrace();
            itPassed = false;
        }
        return itPassed;
    }


}

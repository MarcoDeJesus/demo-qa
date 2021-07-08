package refactored.business.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

    @FindBy(how = How.NAME, using = "s")
    private WebElement searchBox;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public SearchResultsPage searchProductsByText(String searchText){
        searchBox.clear();
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);

        return new SearchResultsPage(driver);
    }
}

package refactored.business.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchResultsPage extends BasePage{

    private static int totalProductsInSearchResultPage;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement header;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/ul/li")
    private List<WebElement> productsInCurrentPageList;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/nav[2]/ul/li")
    private List<WebElement> paginationActionButtonList;

    @FindBy(how = How.XPATH, using = "//*[@id=\"main\"]/div/p")
    private WebElement searchResultsHeader;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public String getHeaderText(){
        return header.getText();
    }

    public int getNumberOfProductsInCurrentPage(){
        setTotalProductsInSearchResultPage(productsInCurrentPageList.size());
        return productsInCurrentPageList.size();
    }

    public void clickOnNextButton() {
        final var LAST_POSITION = 1;
        int paginationItemsCount = paginationActionButtonList.size();
        int lastElementPosition = paginationItemsCount - LAST_POSITION;
        WebElement lastElement = paginationActionButtonList.get(lastElementPosition);
        WebElement nextButton = lastElement.findElement(By.tagName("a"));

        if(nextButton.getAttribute("class").contains("next")){
            lastElement.click();
        }
    }

    public String getHeaderWithTotalProducts(){
        return searchResultsHeader.getText();
    }

    public int getTotalProductsInSearchResult(){
        return totalProductsInSearchResultPage;
    }

    private static void setTotalProductsInSearchResultPage(int productsInPage){
        totalProductsInSearchResultPage += productsInPage;
    }

    public static void resetTotalProductsInSearchResultPage(){
        totalProductsInSearchResultPage = 0;
    }
}

package com.printapp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import refactored.business.pageobjects.HomePage;
import refactored.business.pageobjects.SearchResultsPage;

import static org.testng.Assert.assertEquals;

public class SearchFunctionalityTest extends Base {

    private HomePage homePage;
    private SearchResultsPage resultsPage;

    @BeforeClass
    public void BeforeClass(){
        SetUp();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void AfterClass(){
        CleanUp();
    }

    @BeforeMethod
    public void TestInitialize(){
        SearchResultsPage.resetTotalProductsInSearchResultPage();
        resultsPage = homePage
                .searchProductsByText("tshirt");
    }

    @Test
    public void GivenASearchText_WhenValidatingResults_CorrectCountIsReturned(){
        // Arrange

        // Act
        resultsPage.getNumberOfProductsInCurrentPage();
        resultsPage.clickOnNextButton();
        resultsPage.getNumberOfProductsInCurrentPage();

        // Assert
        assertEquals(resultsPage.getTotalProductsInSearchResult(), 10, "The total number of products" +
                " is not correct.");
    }
    @Test
    public void GivenASearchText_WhenValidatingResultsPageHeader_CorrectTextIsDisplayed(){
        // Arrange

        // Act

        // Assert
        assertEquals(resultsPage.getHeaderText(), "Search results: “tshirt”", "The Header" +
                " text is not correct.");
    }
    @Test
    public void GivenASearchText_WhenValidatingResults_CorrectCountIsReturnedInPageOne(){
        // Arrange

        // Act
        int productsInPageOne = resultsPage.getNumberOfProductsInCurrentPage();

        // Assert
        assertEquals(productsInPageOne, 9, "Number of products is not correct.");
    }

    @Test
    public void GivenASearchText_WhenValidatingResults_CorrectCountIsReturnedInPageTwo(){
        // Arrange

        // Act
        resultsPage.getNumberOfProductsInCurrentPage();
        resultsPage.clickOnNextButton();
        int productsInPageTwo = resultsPage.getNumberOfProductsInCurrentPage();

        // Assert
        assertEquals(productsInPageTwo, 1, "Number of products is not correct.");
    }

    @Test
    public void GivenASearchText_WhenAddingUpPageResults_CorrectCountIsReturned(){
        // Arrange

        // Act
        resultsPage.getNumberOfProductsInCurrentPage();
        resultsPage.clickOnNextButton();
        int productsInPageTwo = resultsPage.getNumberOfProductsInCurrentPage();

        // Assert
        assertEquals(productsInPageTwo, 1, "Number of products is not correct.");
    }

    @Test
    public void GivenASearchText_WhenAddingUpSearchResults_CorrectCountIsReturned(){
        // Arrange

        // Act
        int productsInPageOne = resultsPage.getNumberOfProductsInCurrentPage();
        resultsPage.clickOnNextButton();
        int productsInPageTwo = resultsPage.getNumberOfProductsInCurrentPage();
        int totalNumberOfProducts = productsInPageOne + productsInPageTwo;

        // Assert
        assertEquals(totalNumberOfProducts, 10, "Total number of products is not correct.");
    }

    @Test
    public void GivenAnInvalidSearchText_WhenValidatingResults_ZeroCountIsReturned(){
        // Arrange
        SearchResultsPage resultsPage = homePage
                .searchProductsByText("Invalid product Searched.");

        // Act
        String noProductsMessage = resultsPage.getHeaderWithTotalProducts();

        // Assert
        assertEquals(noProductsMessage, "No products were found matching your selection.",
                "Error message is not correct.");
    }
}

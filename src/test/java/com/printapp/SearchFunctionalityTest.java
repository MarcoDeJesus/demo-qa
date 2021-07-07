package com.printapp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import refactored.business.pageobjects.HomePage;
import refactored.business.pageobjects.SearchResultsPage;

import static org.testng.Assert.assertEquals;

public class SearchFunctionalityTest extends BaseTest{
    @BeforeClass
    public void BeforeClass(){
        SetUp();
    }

    @AfterClass
    public void AfterClass(){
        CleanUp();
    }

    @Test
    public void GivenASearchText_WhenValidatingResults_CorrectCountIsReturned(){
        SearchResultsPage resultsPage = new HomePage(driver)
                .searchProductsByText("tshirt");

        int productsInPageOne = resultsPage.getNumberOfProductsInCurrentPage();
        resultsPage.clickOnNextButton();
        int productsInPageTwo = resultsPage.getNumberOfProductsInCurrentPage();
        int totalNumberOfProducts = productsInPageOne + productsInPageTwo;

        assertEquals(resultsPage.getHeaderText(), "Search results: “tshirt” – Page 2", "The Header text is not correct.");
        assertEquals(productsInPageOne, 9, "Number of products is not correct.");
        assertEquals(productsInPageTwo, 1, "Number of products is not correct.");
        assertEquals(totalNumberOfProducts, 10, "Total number of products is not correct.");
        assertEquals(resultsPage.getTotalProductsInSearchResult(), 10, "The total number of products is not correct.");
        assertEquals(resultsPage.getHeaderWithTotalProducts(), "Showing 10–10 of 10 results", "Search total results is not correct.");

    }
}

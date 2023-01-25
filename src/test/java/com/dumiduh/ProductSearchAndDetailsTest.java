package com.dumiduh;

import com.dumiduh.function.Cart;
import com.dumiduh.function.HeaderMenu;
import com.dumiduh.function.ProductDetails;
import com.dumiduh.function.SearchResults;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.*;


public class ProductSearchAndDetailsTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        inputData = JSONUtil.readTestData(); //reading input data from the test data file.
        driver.get(URL_TEMP);
    }

    @Test
    public static void validateTheProductSearchAndPricingData() {

        HeaderMenu headerMenu = new HeaderMenu(driver);

        headerMenu.selectAValueFromTheSelectSearchCategoryDropdown(inputData.getCategory());
        headerMenu.typeInTheProductSearchTermAndPressEnter(inputData.getSearchTerm());

        SearchResults searchResults = new SearchResults(driver);

        searchResults.filterByFourStarReviews();
        searchResults.filterByLanguage(inputData.getLanguage()); //sync
        String productNameFoundInSearchResults = searchResults.getProductName(inputData.getProductIndex()); //sync
        searchResults.selectProductByIndex(inputData.getProductIndex()); //sync

        ProductDetails productDetails = new ProductDetails(driver); //sync

        double unitPrice = productDetails.getUnitPrice();
        String productNameFoundOnTheProductDetailsPage = productDetails.getProductName();
        productDetails.setQuantity(inputData.getQuantity());

        Assert.assertEquals(productNameFoundOnTheProductDetailsPage, productNameFoundInSearchResults, "The name of the product found in the search results didn't match the name found in the product details page.");

        productDetails.clickAddToCart(); //sync
        headerMenu.clickGoToCart();

        Cart cart = new Cart(driver);
        double subTotal = cart.getSubTotal();
        int actualQuantity = cart.getProductQuantity();
        String productNameFromTheCart = cart.getTheProductName();

        //Asserting the information in the cart.
        assertCartDetails(productNameFromTheCart, productNameFoundOnTheProductDetailsPage, actualQuantity, subTotal,unitPrice);

        cart.clickClearCart();//sync
        Assert.assertTrue(cart.isClearCartSuccessMessageDisplayed(),"The success message was not displayed after clearing the cart.");

    }

    private static void assertCartDetails(String actualProductName, String expectedProductName, int actualQuantity, double subTotal, double unitPrice) {
        //Asserting the product name.
        if (actualProductName.contains(PRODUCT_NAME_POST_FIX)  || actualProductName.length() > THE_LENGTH_AT_WHICH_TO_TRUNCATE_THE_PRODUCT_NAME) {
            actualProductName = actualProductName.substring(0,THE_LENGTH_AT_WHICH_TO_TRUNCATE_THE_PRODUCT_NAME);
            expectedProductName = expectedProductName.substring(0,THE_LENGTH_AT_WHICH_TO_TRUNCATE_THE_PRODUCT_NAME);
        }
        Assert.assertEquals(expectedProductName,actualProductName, "The product name in the product details page and the product name in the cart didn't match.");

        //Asserting the quantity.
        Assert.assertEquals(inputData.getQuantity(),actualQuantity,"The expected quantity and the actual quantity didn't match.");

        //Asserting the price related information.
        Assert.assertEquals(subTotal, unitPrice * inputData.getQuantity(), "The pricing information on the product details didn't match with the information in the cart.");
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}

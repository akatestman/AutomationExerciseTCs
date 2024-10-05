package Tests;

import Pages.CartPage;
import Pages.ProductsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductsInCart extends TestBase{
    ProductsPage product;
    CartPage cart;
    @Test
    public void addProductsInCart(){
        softAssert = new SoftAssert();
        product = new ProductsPage(driver);
        cart = new CartPage(driver);
        product.goToProductsPage();
        int firstProductPriceInProductsPage = product.firstProductPriceInProductsPage();
        int secondProductPriceInProductsPage = product.secondProductPriceInProductsPage();
        product.addFirstProductToCart();
        product.continueShopping();
        product.addSecondProductToCart();
        product.viewCart();
        softAssert.assertTrue(cart.assertFirstProductVisibilityInCart().isDisplayed(),"Not Visible");
        softAssert.assertTrue(cart.assertSecondProductVisibilityInCart().isDisplayed(),"Not Visible");
        int firstProductPriceInCart = cart.firstProductPriceInCart();
        int secondProductPriceInCart = cart.secondProductPriceInCart();
        softAssert.assertEquals(firstProductPriceInProductsPage,firstProductPriceInCart,"different prices");
        softAssert.assertEquals(secondProductPriceInProductsPage,secondProductPriceInCart,"different prices");
        int totalInProductsPage = firstProductPriceInProductsPage + secondProductPriceInProductsPage;
        int totalInCart = firstProductPriceInCart + secondProductPriceInCart;
        softAssert.assertEquals(totalInProductsPage,totalInCart,"different prices");
        softAssert.assertAll();

    }
}

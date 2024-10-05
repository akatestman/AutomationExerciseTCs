package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.RegisterPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterWhileCheckout extends TestBase{
    HomePage home;
    CartPage cart;
    RegisterPage register;
    @Test
    public void placeOrderRegisterwhileCheckout() throws InterruptedException {
        softAssert = new SoftAssert();
        faker = new Faker();
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password();
        String fName = faker.name().firstName();
        String lName = faker.name().lastName();
        String name = fName+" "+lName;
        String cardNumber = faker.finance().creditCard();
        String address = faker.address().fullAddress();
        home = new HomePage(driver);
        cart = new CartPage(driver);
        register = new RegisterPage(driver);
        home.addProductsInCart();
        home.goToCartPage();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/view_cart","Wrong URL");
        cart.goToCheckout();
        cart.goToSignUpPage();
        register.enterNameAndEmail(name,email);
        register.enterAccountInfo(password,5,5,26,fName,lName,address,3,"Egypt","Cairo","113366","01123456789");
        register.submitCreateAccount();
        softAssert.assertTrue(register.assertAccountCreatedIsVisible().isDisplayed(),"Not Visible");
        register.clickContinue();
        softAssert.assertTrue(register.assertLoggedInAsIsVisible().isDisplayed(),"Not Visible");
        cart.goToCartPage();
        cart.goToCheckout();
        softAssert.assertEquals(cart.assertAddressInCheckout(),address,"Wrong Address");
        cart.writeMessage("I Hope Get The Order Fast");
        cart.clickPlaceOrder();
        cart.makePayment("Ahmed",cardNumber,"635","08","2029");
        cart.payAndConfirmOrder();
        Thread.sleep(1000);
        softAssert.assertTrue(cart.assertSuccessMessageAfterPayIsVisible().isDisplayed(),"Not Visible");
        register.clickDeleteAccount();
        softAssert.assertTrue(register.assertAccountDeletedIsVisible().isDisplayed(),"Not Visible");
        softAssert.assertAll();
    }
}

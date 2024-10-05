package Tests;

import Pages.LoginPage;
import Pages.RegisterPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ReagisterAndLogin extends TestBase{
    RegisterPage register ;
    LoginPage login;
    public String email ;
    public String password ;
    public String fName ;
    public String lName ;
    public String name = fName+" "+lName;



    @Test(priority = 1)
    public void registerWithValidData(){
        softAssert = new SoftAssert();
        register = new RegisterPage(driver);
        faker = new Faker();
        fName = faker.name().firstName();
        lName = faker.name().lastName();
        name = fName+" "+lName;
        email = faker.internet().safeEmailAddress();
        password = faker.internet().password();
        String address = faker.address().fullAddress();

        register.goToRegisterPage();
        softAssert.assertEquals(register.assertNewUserSignupText(),"new user signup!","Wrong Text");
        register.enterNameAndEmail(name,email);
        softAssert.assertEquals(register.assertEnterAccountInfoText(),"enter account information","Wrong Text");
        register.enterAccountInfo(password,5,5,26,fName,lName,address,3,"Egypt","Cairo","113366","01123456789");
        register.submitCreateAccount();
        softAssert.assertTrue(register.assertAccountCreatedIsVisible().isDisplayed(),"Not Visible");
        register.clickContinue();
        softAssert.assertTrue(register.assertLoggedInAsIsVisible().isDisplayed(),"Not Visible");
        register.clickLogoutButton();
        softAssert.assertAll();
    }
    @Test (priority = 2)
    public void registerWithExistingEmail(){
        softAssert = new SoftAssert();
        register = new RegisterPage(driver);
        register.goToRegisterPage();
        softAssert.assertEquals(register.assertNewUserSignupText(),"new user signup!","Wrong Text");
        register.enterNameAndEmail(name,email);
        softAssert.assertTrue(register.assertEmailAlreadyExistIsVisible().isDisplayed(),"Not Visible");
        softAssert.assertAll();

    }
    @Test(priority = 3)
    public void logoutUser(){
        softAssert = new SoftAssert();
        login = new LoginPage(driver);
        login.goToLoginPage();
        softAssert.assertTrue(login.assertLoginToYourAccountIsVisible().isDisplayed(),"Not Visible");
        login.loginToYourAccount(email,password);
        login.clickOnLoginButton();
        softAssert.assertTrue(login.assertLoggedInAsUserIsVisible().isDisplayed(),"Not Visible");
        login.clickLogoutButton();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login","Wrong URL");
        softAssert.assertAll();
    }

    @Test (priority = 4)
    public void loginWithValidData(){
        softAssert = new SoftAssert();
        login = new LoginPage(driver);
        login.goToLoginPage();
        softAssert.assertTrue(login.assertLoginToYourAccountIsVisible().isDisplayed(),"Not Visible");
        login.loginToYourAccount(email,password);
        login.clickOnLoginButton();
        softAssert.assertTrue(login.assertLoggedInAsUserIsVisible().isDisplayed(),"Not Visible");
        login.clickDeleteAccount();
        softAssert.assertTrue(login.assertAccountDeletedIsVisible().isDisplayed(),"Not Visible");
        softAssert.assertAll();

    }
    @Test (priority = 5)
    public void loginWithInvalidData(){
        softAssert = new SoftAssert();
        login = new LoginPage(driver);
        login.goToLoginPage();
        softAssert.assertTrue(login.assertLoginToYourAccountIsVisible().isDisplayed(),"Not Visible");
        login.loginToYourAccount("pablo2000@gmail.com","1234567890");
        login.clickOnLoginButton();
        softAssert.assertTrue(login.assertYourEmailOrPasswordIsInCorrect().isDisplayed(),"Not Visible");
        softAssert.assertAll();
    }
}

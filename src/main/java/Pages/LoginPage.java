package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Base{
    final private By loginButtonHomePage = By.xpath("//*[@href=\"/login\"]");
    final private By emailFieldLocator = By.xpath("//*[@data-qa=\"login-email\"]");
    final private By passwordFieldLocator = By.xpath("//*[@data-qa=\"login-password\"]");
    final private By loginButton = By.xpath("//*[@data-qa=\"login-button\"]");
    final private By loginToYourAccountText=By.xpath("//*[@class=\"login-form\"]/h2");
    final private By loggedInAsText = By.xpath("//*[@class=\"nav navbar-nav\"]/li[10]//b");
    final private By deleteAccountButton = By.xpath("//*[@href=\"/delete_account\"]");
    final private By accountDeletedText = By.xpath("//*[@class=\"col-sm-9 col-sm-offset-1\"]/h2");
    final private By yourEmailOrPasswordIsInCorrectText = By.xpath("//*[@style=\"color: red;\"]");
    final private By logoutButton = By.xpath("//*[@href=\"/logout\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void goToLoginPage(){
        click(loginButtonHomePage);
    }
    public WebElement assertLoginToYourAccountIsVisible(){
        return driver.findElement(loginToYourAccountText);
    }
    public void loginToYourAccount(String email,String password){
        sendKeys(emailFieldLocator,email);
        sendKeys(passwordFieldLocator,password);
    }
    public void clickOnLoginButton(){
        click(loginButton);
    }
    public WebElement assertLoggedInAsUserIsVisible(){
        return driver.findElement(loggedInAsText);
    }
    public void clickLogoutButton(){
        click(logoutButton);
    }
    public void clickDeleteAccount(){
        click(deleteAccountButton);
    }
    public WebElement assertAccountDeletedIsVisible(){
        return driver.findElement(accountDeletedText);
    }
    public WebElement assertYourEmailOrPasswordIsInCorrect(){
        return driver.findElement(yourEmailOrPasswordIsInCorrectText);
    }
}

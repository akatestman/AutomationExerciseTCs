package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends Base{
    final private By signupButtonHomePage = By.xpath("//*[@href=\"/login\"]");
    final private By nameFieldLocator = By.xpath("//*[@data-qa=\"signup-name\"]");
    final private By emailFieldLocator = By.xpath("//*[@data-qa=\"signup-email\"]");
    final private By signupButton = By.xpath("//*[@data-qa=\"signup-button\"]");
    final private By maleGenderLocator = By.xpath("//*[@id=\"id_gender1\"]");
    final private By femaleGenderLocator = By.xpath("//*[@id=\"id_gender2\"]");
    final private By passwordFieldLocator = By.xpath("//*[@data-qa=\"password\"]");
    final private By selectDayLocator = By.xpath("//*[@id=\"days\"]");
    final private By selectMonthLocator = By.xpath("//*[@id=\"months\"]");
    final private By selectYearLocator = By.xpath("//*[@id=\"years\"]");
    final private By firstNameFieldLocator = By.xpath("//*[@data-qa=\"first_name\"]");
    final private By lastNameFieldLocator = By.xpath("//*[@data-qa=\"last_name\"]");
    final private By addressFieldLocator = By.xpath("//*[@data-qa=\"address\"]");
    final private By selectCountryLocator = By.xpath("//*[@data-qa=\"country\"]");
    final private By stateFieldLocator = By.xpath("//*[@data-qa=\"state\"]");
    final private By cityFieldLocator = By.xpath("//*[@data-qa=\"city\"]");
    final private By zipcodeFieldLocator = By.xpath("//*[@data-qa=\"zipcode\"]");
    final private By mobNumberFieldLocator = By.xpath("//*[@data-qa=\"mobile_number\"]");
    final private By createAccountButtonLocator = By.xpath("//*[@data-qa=\"create-account\"]");
    final private By newUserSignupText = By.xpath("//*[@class=\"signup-form\"]/h2");
    final private By enterAccountInformationText = By.xpath("//*[@class=\"login-form\"]/h2/b");
    final private By accountCreatedText = By.xpath("//*[@class=\"col-sm-9 col-sm-offset-1\"]/h2");
    final private By continueButton = By.xpath("//*[@data-qa=\"continue-button\"]");
    final private By loggedInAsText = By.xpath("//*[@class=\"nav navbar-nav\"]/li[10]//b");
    final private By deleteAccountButton = By.xpath("//*[@href=\"/delete_account\"]");
    final private By accountDeletedText = By.xpath("//*[@class=\"col-sm-9 col-sm-offset-1\"]/h2");
    final private By logoutButton = By.xpath("//*[@href=\"/logout\"]");
    final private By emailAdressAlreadyExistLocator = By.xpath("//*[@style=\"color: red;\"]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public void goToRegisterPage(){
        click(signupButtonHomePage);
    }
    public String assertNewUserSignupText(){
        return driver.findElement(newUserSignupText).getText().toLowerCase();
    }

    public void enterNameAndEmail(String name ,String email){
        sendKeys(nameFieldLocator,name);
        sendKeys(emailFieldLocator,email);
        click(signupButton);
    }
    public String assertEnterAccountInfoText(){
        return driver.findElement(enterAccountInformationText).getText().toLowerCase();
    }

    public void enterAccountInfo(String password,int day,int month,int year,String fName,String lName,String address,int country,String state,String city,String zipcode,String mobNumber){
        click(maleGenderLocator);
        sendKeys(passwordFieldLocator,password);
        selectByIndex(selectDayLocator,day);
        selectByIndex(selectMonthLocator,month);
        selectByIndex(selectYearLocator,year);
        sendKeys(firstNameFieldLocator,fName);
        sendKeys(lastNameFieldLocator,lName);
        sendKeys(addressFieldLocator,address);
        selectByIndex(selectCountryLocator,country);
        sendKeys(stateFieldLocator,state);
        sendKeys(cityFieldLocator,city);
        sendKeys(zipcodeFieldLocator,zipcode);
        sendKeys(mobNumberFieldLocator,mobNumber);
    }
    public void submitCreateAccount(){
        click(createAccountButtonLocator);
    }
    public WebElement assertAccountCreatedIsVisible(){
        return driver.findElement(accountCreatedText);
    }
    public void clickContinue(){
        click(continueButton);
    }
    public WebElement assertLoggedInAsIsVisible(){
        return driver.findElement(loggedInAsText);
    }
    public void clickDeleteAccount(){
        click(deleteAccountButton);
    }
    public WebElement assertAccountDeletedIsVisible(){
        return driver.findElement(accountDeletedText);
    }
    public void clickLogoutButton(){
        click(logoutButton);
    }
    public WebElement assertEmailAlreadyExistIsVisible(){
        return driver.findElement(emailAdressAlreadyExistLocator);
    }
}

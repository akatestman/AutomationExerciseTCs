package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends Base{
    final private By cartButton = By.xpath("//*[@class=\"nav navbar-nav\"]/li[3]/a");
    final private By firstProductLocator = By.xpath("//*[@id=\"product-1\"]");
    final private By firstProductPrice = By.xpath("//*[@id=\"product-1\"]/td[3]/p");
    final private By secondProductLocator = By.xpath("//*[@id=\"product-2\"]");
    final private By secondProductPrice = By.xpath("//*[@id=\"product-2\"]/td[3]/p");
    final private By proccedToCheckoutButton = By.xpath("//*[@class=\"btn btn-default check_out\"]");
    final private By loginSignUpButtonInCheckout = By.xpath("//*[@class=\"modal-body\"]/p[2]/a");
    final private By addressLoocatorInCheckout = By.xpath("//*[@class=\"address item box\"]/li[4]");
    final private By messageFieldInCheckout = By.xpath("//*[@class=\"form-control\"]");
    final private By placeOrderButtonInCheckout = By.xpath("//*[@href=\"/payment\"]");
    final private By nameOnCardField = By.xpath("//*[@class=\"form-control\"]");
    final private By cardNumberField = By.xpath("//*[@name=\"card_number\"]");
    final private By cvcField = By.xpath("//*[@name=\"cvc\"]");
    final private By expirationMonthField = By.xpath("//*[@class=\"form-control card-expiry-month\"]");
    final private By expirationYearField = By.xpath("//*[@name=\"expiry_year\"]");
    final private By payAndConfirmOrder = By.xpath("//*[@id=\"submit\"]");
    final private By successMessageAfterPay = By.xpath("//*[@style=\"font-size: 20px; font-family: garamond;\"]");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void goToCartPage(){
        click(cartButton);
    }

    public WebElement assertFirstProductVisibilityInCart(){
        return driver.findElement(firstProductLocator);
    }
    public WebElement assertSecondProductVisibilityInCart(){
        return driver.findElement(secondProductLocator);
    }
    public int firstProductPriceInCart(){
        String stringPrice = driver.findElement(firstProductPrice).getText().replaceAll("[^0-9]","");
        int integerPrice = Integer.parseInt(stringPrice);
        return integerPrice;
    }
    public int secondProductPriceInCart(){
        String stringPrice = driver.findElement(secondProductPrice).getText().replaceAll("[^0-9]","");
        int integerPrice = Integer.parseInt(stringPrice);
        return integerPrice;
    }

    public void goToCheckout(){
        click(proccedToCheckoutButton);
    }
    public void goToSignUpPage(){
        click(loginSignUpButtonInCheckout);
    }
    public String assertAddressInCheckout(){
        return driver.findElement(addressLoocatorInCheckout).getText();
    }
    public void writeMessage(String message){
        sendKeys(messageFieldInCheckout,message);
    }
    public void clickPlaceOrder(){
        click(placeOrderButtonInCheckout);
    }
    public void makePayment(String name,String cardNumber,String cvc,String exMonth,String exYear){
        sendKeys(nameOnCardField,name);
        sendKeys(cardNumberField,cardNumber);
        sendKeys(cvcField,cvc);
        sendKeys(expirationMonthField,exMonth);
        sendKeys(expirationYearField,exYear);
    }
    public void payAndConfirmOrder(){
        click(payAndConfirmOrder);
    }
    public WebElement assertSuccessMessageAfterPayIsVisible(){
        return driver.findElement(successMessageAfterPay);
    }
}

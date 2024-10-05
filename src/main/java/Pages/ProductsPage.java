package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends Base{
    final private By productsHomePageButton = By.xpath("//*[@href=\"/products\"]");
    final private By firstProductLocator = By.xpath("//*[@class=\"features_items\"]/div[2]//div[@class=\"product-overlay\"]");
    final private By firstProductAddToCartButton = By.xpath("//*[@class=\"overlay-content\"]/a[@data-product-id=\"1\"]");
    final private By firstProductPriceInProductsPage = By.xpath("//*[@class=\"features_items\"]/div[2]//*[@class=\"productinfo text-center\"]/h2");
    final private By secondProductLocator = By.xpath("//*[@class=\"features_items\"]/div[3]//div[@class=\"product-overlay\"]");
    final private By secondProductAddToCartButton = By.xpath("//*[@class=\"overlay-content\"]/a[@data-product-id=\"2\"]");
    final private By secondProductPriceInProductsPage = By.xpath("//*[@class=\"features_items\"]/div[3]//*[@class=\"productinfo text-center\"]/h2");
    final private By continueShoppingButton = By.xpath("//*[@class=\"btn btn-success close-modal btn-block\"]");
    final private By viewCartButton = By.xpath("//*[@class=\"modal-body\"]/p[2]/a");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void goToProductsPage(){
        click(productsHomePageButton);
    }

    public void addFirstProductToCart(){
        hover(firstProductLocator);
        click(firstProductAddToCartButton);
    }
    public void continueShopping(){
        click(continueShoppingButton);
    }
    public void addSecondProductToCart(){
        hover(secondProductLocator);
        click(secondProductAddToCartButton);
    }
    public void viewCart(){
        click(viewCartButton);
    }
    public int firstProductPriceInProductsPage(){
        String stringPrice = driver.findElement(firstProductPriceInProductsPage).getText().replaceAll("[^0-9]","");
        int integerPrice = Integer.parseInt(stringPrice);
        return integerPrice;
    }
    public int secondProductPriceInProductsPage(){
        String stringPrice = driver.findElement(secondProductPriceInProductsPage).getText().replaceAll("[^0-9]","");
        int integerPrice = Integer.parseInt(stringPrice);
        return integerPrice;
    }


}

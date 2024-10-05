package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Base{
    Faker faker ;
    final private By continueShoppingButton = By.xpath("//*[@class=\"btn btn-success close-modal btn-block\"]");
    final private By cartButton = By.xpath("//*[@class=\"nav navbar-nav\"]/li[3]/a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By viewProductLocator(int index){
        return By.xpath("//*[@class=\"features_items\"]/div["+index+"]/div/div[2]/ul/li/a");
    }
    public void chooseAnyProductFromHomePage(){
        faker = new Faker();
        int chosenProduct = faker.number().numberBetween(2,35);
        click(viewProductLocator(chosenProduct));

    }
    private By productLocator(int index){
        return By.xpath("//*[@class=\"features_items\"]/div["+index+"]//*[@class=\"product-overlay\"]");
    }
    private By productAddToCartButton(int index){
        return By.xpath("//*[@class=\"features_items\"]/div["+index+"]/div/div[1]/div[2]/div/a");
    }
    public void addProductsInCart(){
        faker = new Faker();
        int fristProduct = faker.number().numberBetween(2,35);
        int secondProduct;
        do {
            secondProduct = faker.number().numberBetween(2,35);
        }while (secondProduct == fristProduct);
        hover(productLocator(fristProduct));
        click(productAddToCartButton(fristProduct));
        click(continueShoppingButton);
        hover(productLocator(secondProduct));
        click(productAddToCartButton(secondProduct));
    }
    public void goToCartPage(){
        click(cartButton);
    }
}

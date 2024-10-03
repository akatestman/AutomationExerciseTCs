package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    protected WebDriver driver;
    protected Actions actions;
    protected Select select;
    protected WebDriverWait wait;

    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    protected void waitUntilElementBeClickable(By by){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    protected void click(WebElement element){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    protected void click(By by){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
    protected void sendKeys(WebElement element,String text){
        element.clear();
        element.sendKeys(text);

    }
    protected void sendKeys(By by,String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    protected void hover(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    protected void hover(By by){
        actions =new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }
    protected void selectByIndex(By by , int index){
        select = new Select(driver.findElement(by));
        select.selectByIndex(index);

    }
    protected void selectByValue(By by,String value){
        select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }
}

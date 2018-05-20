package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;

/**
 * Created by Rogoza Dimity on 19.05.2018.
 */
public class CreditForHouse extends BasePage  {
    @FindBy(xpath = "//*[@class = 'sbrf-div-list-inner --area bp-area col-xs-12 col-sm-12 col-md-3']//child::span")
    List<WebElement> menuApplication;

    @FindBy(xpath = "//*[@class ='kit-link kit-link_color_black personal-data-warning__close personal-data-warning__close_ru']")
    WebElement closeBanner;
    public CreditForHouse(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void clickAction(String action){
        closeBanner.click();
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView(false);", selectItem(menuApplication,action));
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 15);
        wait.until(ExpectedConditions.elementToBeClickable(selectItem(menuApplication,action)));
        new Actions(BaseSteps.getDriver()).moveToElement(selectItem(menuApplication,action)).click().perform();
    }
}

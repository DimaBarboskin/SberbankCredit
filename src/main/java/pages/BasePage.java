package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;

/**
 * Created by Rogoza Dimity on 18.05.2018.
 */
public class BasePage {

    public BasePage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public WebElement selectItem(List<WebElement> elements, String item) {
        for (WebElement element : elements) {
            if (item.equalsIgnoreCase(element.getText())) {
                return element;
            }
        }
        Assert.fail("Не найден элемент коллекции: " + item);
        return null;
    }

    public void waiting(WebElement element){
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void fillField(WebElement element, String value)  {
        element.clear();
        element.sendKeys(value);
    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

/**
 * Created by Rogoza Dimity on 19.05.2018.
 */
public class MainPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),'Взять')]")
    WebElement takeCredit;

    @FindBy(xpath = "//*[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_2']")
    List<WebElement> menu;

    public void MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void clickCredit(){
        takeCredit.click();
    }

    public void selectMenu(String item){
        selectItem(menu,item).click();
    }
}

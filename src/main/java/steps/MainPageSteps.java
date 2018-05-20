package steps;

import io.qameta.allure.Step;
import pages.MainPage;

/**
 * Created by Rogoza Dimity on 19.05.2018.
 */
public class MainPageSteps {

    @Step("Выбираем кредит")
    public void clickCredit(){
        new MainPage().clickCredit();
    }

    @Step("Выбираем пункт")
    public void selectMenu(String item){
        new MainPage().selectMenu(item);
    }
}

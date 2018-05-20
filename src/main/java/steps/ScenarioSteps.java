package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * Created by Rogoza Dimity on 19.05.2018.
 */
public class ScenarioSteps {
    MainPageSteps mainPageSteps = new MainPageSteps();

    CreditForHousePageSteps creditForHousePageSteps = new CreditForHousePageSteps();

    CreditFormPageSteps creditFormPageSteps = new CreditFormPageSteps();

    @When("^выбираем кредит")
    public void clickCredit(){
        mainPageSteps.clickCredit();
    }

    @When("^выбираем пункт (.*)$")
    public void selectMenu(String item){
        mainPageSteps.selectMenu(item);
    }

    @When("^выбираем действие (.*)$")
    public void clickAction(String action){
       creditForHousePageSteps.clickAction(action); ;
    }

    @Then("^проверяем заголовок (.*)$")
    public void checkTitle(String title){
        creditFormPageSteps.checkTitle(title); ;
    }

    @When("^заполняем поля:$")
    public void fillFields(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> creditFormPageSteps.fillFields(field, value)); ;
    }

    @When("^выбираем чекюоксы (.+)$")
    public void clickCheckBoxes(List<String> checkBoxes){
        creditFormPageSteps.clickCheckBoxes(checkBoxes); ;
    }

    @When("^значения полей:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> creditFormPageSteps.checkNumbers(field, value));
    }

}

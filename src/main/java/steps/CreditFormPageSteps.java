package steps;

import io.qameta.allure.Step;
import pages.CreditForm;

import java.util.List;

/**
 * Created by Rogoza Dimity on 19.05.2018.
 */
public class CreditFormPageSteps {

    @Step()
    public void checkTitle(String title){
        new CreditForm().checkTitle(title);
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillFields(String field, String value){
        new CreditForm().fillFields(field,value);
    }
    @Step()
    public void clickCheckBoxes(List<String> checkBoxes){
        new CreditForm().clickCheckBoxes(checkBoxes);
    }

    @Step("значение поля {0} равно {1}")
    public void checkNumbers(String numbers, String value){
        new CreditForm().checkNumbers(numbers,value);
    }
}

package steps;

import io.qameta.allure.Step;
import pages.CreditForHouse;

/**
 * Created by Rogoza Dimity on 19.05.2018.
 */
public class CreditForHousePageSteps {

    @Step()
    public void clickAction(String action){
        new CreditForHouse().clickAction(action);
    }
}

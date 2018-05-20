package application;

import gherkin.formatter.model.Result;
import io.qameta.allure.cucumberjvm.AllureCucumberJvm;
import steps.BaseSteps;


/**
 * Created by Rogoza Dimity on 14.05.2018.
 */
public class AllureReporter extends AllureCucumberJvm {

    @Override
    public void result(final Result result) {
        if (result.getStatus().equals("failed")){
            BaseSteps.takeScreenshot();
        }
        super.result(result);
    }


}




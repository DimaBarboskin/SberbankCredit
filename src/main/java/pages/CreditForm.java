package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rogoza Dimity on 19.05.2018.
 */
public class CreditForm extends BasePage{
    @FindBy(xpath = "//*[@class = 'headerTitle___22vI']")
    WebElement title;

    @FindBy(xpath = "//*[@class ='dcCalc_textfield__suffix']")
    WebElement select;

    @FindBy(xpath = "//*[@id ='estateCost']")
    WebElement price;

    @FindBy(xpath = "//*[@id ='initialFee']")
    WebElement firstPay;

    @FindBy(xpath = "//*[@id ='creditTerm']")
    WebElement creditTerm;

    @FindBy(xpath = "//*[@class ='dcCalc_switch-desktop']")
    List<WebElement> checkbox;

    @FindBy(xpath = "//*[@data-test-id='amountOfCredit']")
    WebElement amountCreit;

    @FindBy(xpath = "//*[@data-test-id='monthlyPayment']")
    WebElement monthlyPayment;

    @FindBy(xpath = "//*[@data-test-id='requiredIncome']")
    WebElement requiredIncome;

    @FindBy(xpath = "//*[@data-test-id='rate']")
    WebElement rate;

    public CreditForm(){
        PageFactory.initElements(BaseSteps.getDriver(),this);
    }

    public void checkTitle(String title){
        ArrayList<String> tabs = new ArrayList (BaseSteps.getDriver().getWindowHandles());
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 20);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        BaseSteps.getDriver().switchTo().window(tabs.get(1));
        waiting(this.title);
        Assert.assertEquals("Заголовок не совпадает: ", title,this.title.getText());
    }

   public void fillFields(String fieldName, String value){
        switch (fieldName){
            case  "Цель кредита":
                WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
                wait.until(ExpectedConditions.elementToBeClickable(select));
                select.click();
                BaseSteps.getDriver().findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
                break;
            case  "Стоимость недвижимости":
                fillField(price,value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case  "Первоначальный взнос":
                fillField(firstPay, value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case  "Срок кредитования":
                fillField(creditTerm,value);
                try {
                    Thread.sleep(500);
               } catch (InterruptedException e) {
                    e.printStackTrace();
               }
                break;
            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void clickCheckBoxes(List<String> checkBoxes){
        for(String check: checkBoxes) {
            waiting(BaseSteps.getDriver().findElement(By.xpath("//div[contains(text(),'" + check + "')]//parent::div//parent::div//descendant::label")));
            BaseSteps.getDriver().findElement(By.xpath("//div[contains(text(),'" + check + "')]//parent::div//parent::div//descendant::label")).click();
        }
   }
    public void checkNumbers(String numbers, String value){
        switch (numbers){
            case  "Сумма кредита":
                WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 10);
                wait.until(ExpectedConditions.textToBe(By.xpath("//*[@data-test-id='amountOfCredit']"),value));
                Assert.assertEquals("Не совпадают значения: ", value,BaseSteps.getDriver().findElement(By.xpath(
                        "//*[@data-test-id='amountOfCredit']")).getText());
                break;
            case  "Ежемесячный платеж":
                WebDriverWait wait1 = new WebDriverWait(BaseSteps.getDriver(), 10);
                wait1.until(ExpectedConditions.textToBe(By.xpath("//*[@data-test-id='monthlyPayment']"),value));
                Assert.assertEquals("Не совпадают значения: ", value,BaseSteps.getDriver().findElement(By.xpath(
                        "//*[@data-test-id='monthlyPayment']")).getText());
                break;
            case  "Необходимый доход":
                WebDriverWait wait2 = new WebDriverWait(BaseSteps.getDriver(), 10);
                wait2.until(ExpectedConditions.textToBe(By.xpath("//*[@data-test-id='requiredIncome']"),value));
                Assert.assertEquals("Не совпадают значения: ", value,BaseSteps.getDriver().findElement(By.xpath(
                        "//*[@data-test-id='requiredIncome']")).getText());
                break;
            case  "Процентная ставка":
                WebDriverWait wait3 = new WebDriverWait(BaseSteps.getDriver(), 10);
                wait3.until(ExpectedConditions.textToBe(By.xpath("//*[@data-test-id='rate']"),value));
                Assert.assertEquals("Не совпадают значения: ", value,BaseSteps.getDriver().findElement(By.xpath(
                        "//*[@data-test-id='rate']")).getText());
                break;
            default:  throw new AssertionError("Поле '"+numbers+"' не объявлено на странице");
        }
    }
}

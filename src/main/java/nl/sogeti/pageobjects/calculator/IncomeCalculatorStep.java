package nl.sogeti.pageobjects.calculator;

import nl.sogeti.data.model.Income;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IncomeCalculatorStep {
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/input")
    WebElement brutoYearlyIncome;
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[2]/div[2]/div/input")
    WebElement age;
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div/div[1]")
    WebElement single;
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[2]/div/div[1]")
    WebElement notSingle;
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[4]/button")
    WebElement continue_Btn;

    public IncomeCalculatorStep(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterIncomeData(Income income) {
        brutoYearlyIncome.click();
        brutoYearlyIncome.sendKeys(income.getIncome());
        age.click();
        age.sendKeys(income.getAge());
        if (income.getIsSingle().equals("y")) {
            single.click();
        } else {
            notSingle.click();
        }

        continue_Btn.sendKeys("\n");
    }
}

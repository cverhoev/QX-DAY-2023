package nl.sogeti.pageobjects.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

    public MortgageAmountCalculatorStep mortgageAmountCalculatorStep;
    public IncomeCalculatorStep incomeCalculatorStep;
    public CreditsAndLoansCalculatorStep creditsAndLoansCalculatorStep;
    public MortgageTypeCalculatorStep mortgageTypeCalculatorStep;

    public ResultCalculatorStep resultCalculatorStep;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[1]/div[2]/button")
    WebElement clearAllElements;


    public CalculatorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        mortgageAmountCalculatorStep = new MortgageAmountCalculatorStep(driver);
        incomeCalculatorStep = new IncomeCalculatorStep(driver);
        creditsAndLoansCalculatorStep = new CreditsAndLoansCalculatorStep(driver);
        mortgageTypeCalculatorStep = new MortgageTypeCalculatorStep(driver);
        resultCalculatorStep = new ResultCalculatorStep(driver);
    }

}

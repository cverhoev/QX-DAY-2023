package nl.sogeti.pageobjects.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MortgageTypeCalculatorStep {
    public MortgageTypeCalculatorStep(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

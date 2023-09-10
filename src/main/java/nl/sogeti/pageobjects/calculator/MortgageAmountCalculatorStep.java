package nl.sogeti.pageobjects.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MortgageAmountCalculatorStep {
    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/div[2]/form/div[2]/button")
    WebElement continue_Btn;

    public MortgageAmountCalculatorStep(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void clickContinueBtn() throws InterruptedException {
        continue_Btn.click();
        Thread.sleep(2000); // wait second to refresh
    }

}

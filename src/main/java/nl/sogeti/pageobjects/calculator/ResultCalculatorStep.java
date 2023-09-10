package nl.sogeti.pageobjects.calculator;

import nl.sogeti.data.model.MonthlyCosts;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultCalculatorStep {
    @FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]/div[2]/div[1]/div[2]")
    WebElement monthlyBrutoCosts_Txt;

    @FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]/div[2]/div[2]/div[2]")
    WebElement monthlyNettoCosts_Txt;

    public ResultCalculatorStep(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void assertMonthlyCosts(MonthlyCosts monthlyCosts) {
        var brutoAmount = monthlyBrutoCosts_Txt.getText();
        var nettoAmount = monthlyNettoCosts_Txt.getText();
        Assert.assertEquals(monthlyCosts.getBruto(), brutoAmount);
        Assert.assertEquals(monthlyCosts.getNetto(), nettoAmount);

    }
}

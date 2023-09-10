package nl.sogeti.screenplay.calculator;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MortgageAmountCalculatorStepPage extends PageObject {
    public static final Target continueing =
            Target.the("Continue calculator").
                    located(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/div[2]/form/div[2]/button"));

}

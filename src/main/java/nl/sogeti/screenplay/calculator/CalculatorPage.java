package nl.sogeti.screenplay.calculator;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CalculatorPage extends PageObject {
    public static final Target clearAllElements =
            Target.the("Clear all input elements").
                    located(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button"));
}

package nl.sogeti.screenplay.calculator;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultCalculatorStepPage extends PageObject {
    public static final Target monthlyGrossCosts =
            Target.the("Calculated monthly gross mortgage costs").
                    located(By.xpath("//*[@id=\"summary\"]/div[2]/div[1]/div[2]"));
    public static final Target monthlyNettoCosts =
            Target.the("Calculated monthly netto mortgage costs").
                    located(By.xpath("//*[@id=\"summary\"]/div[2]/div[2]/div[2]"));

}

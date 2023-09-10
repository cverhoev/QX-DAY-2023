package nl.sogeti.screenplay.calculator;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IncomeCalculatorStepPage extends PageObject {
    public static final Target brutoYearlyIncome =
            Target.the("Bruto yearly income").
                    located(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/input"));
    public static final Target age =
            Target.the("Age").
                    located(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[2]/div[2]/div/input"));
    public static final Target single =
            Target.the("Not in a relationship").
                    located(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[1]/div/div[1]"));
    public static final Target notSingle =
            Target.the("In a relationship").
                    located(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[3]/div[2]/div[2]/div/div[1]"));
    public static final Target continueing =
            Target.the("Continue calculator").
                    located(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[2]/div[2]/form/div[4]/button"));

}

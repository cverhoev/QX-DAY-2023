package nl.sogeti.screenplay;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("https://www.hypotheker.nl/zelf-berekenen/wat-worden-mijn-maandlasten/")
public class StartPage extends PageObject {
    public static final Target acceptAllCookiesButton =
            Target.the("Accept all cookies button").
                    located(By.xpath("/html/body/div[6]/div[1]/div/div/div/div/div/button"));
    public static final Target mortgageTotalAmount =
            Target.the("Total mortgage amount text field").
                    located(By.xpath("/html/body/main/div[2]/div/div/div[1]/div[2]/div/section[1]/div/div[1]/input"));
    public static final Target calculate =
            Target.the("Calculate button").
                    located(By.xpath("/html/body/main/div[2]/div/div/div[1]/div[2]/div/section[1]/div/div[2]/a"));
}

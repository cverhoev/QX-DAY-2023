package nl.sogeti.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "/html/body/main/div[2]/div/div/div[1]/div[2]/div/section[1]/div/div[1]/input")
    WebElement mortgageTotalAmount_TF;
    @FindBy(how = How.XPATH, using = "/html/body/main/div[2]/div/div/div[1]/div[2]/div/section[1]/div/div[2]/a")
    WebElement calculate_Btn;
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[1]/div/div/div/div/div/button")
    WebElement acceptCookies_Btn;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToStartPage() throws InterruptedException {
        driver.get("https://www.hypotheker.nl/zelf-berekenen/wat-worden-mijn-maandlasten/");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        acceptCookie(wait);
    }

    public void enterMortgageTotalAmount(int amount) {
        mortgageTotalAmount_TF.sendKeys(String.valueOf(amount));
        calculate_Btn.click();
    }

    private void acceptCookie(WebDriverWait wait) throws InterruptedException {
        //accept cookie button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[1]/div/div/div/div/div/button")));
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div/div/div/button")).click();
        Thread.sleep(1000); // wait second to accept cookie
    }

}

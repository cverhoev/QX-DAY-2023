package nl.sogeti.raw;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RawSeleniumTest {
    private static ChromeDriver driver;
    @BeforeClass
    public static void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeBrowser() {
        driver.quit();
    }

    @Test
    public void calculateMortgage() throws InterruptedException {
        driver.get("https://www.hypotheker.nl/zelf-berekenen/wat-worden-mijn-maandlasten/");
        var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        acceptCookie(wait);

        //mortgage amount text field
        driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div[1]/div[2]/div/" +
                        "section[1]/div/div[1]/input")).sendKeys("300000");
        //calculate button
        driver.findElement(
                By.xpath("/html/body/main/div[2]/div/div/div[1]/div[2]/div/" +
                        "section[1]/div/div[2]/a")).click();
        //continue button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/div[2]/form/div[2]/button")));
        driver.findElement(
                By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/div[1]/div[2]/form/div[2]/button")).click();
        Thread.sleep(1000); // wait second to refresh

        var brutoAmount = driver.findElement(By.xpath("//*[@id=\"summary\"]/div[2]/div[1]/div[2]")).getText();
        Assert.assertEquals("€ 1.447", brutoAmount);
    }

    private static void acceptCookie(WebDriverWait wait) throws InterruptedException {
        //accept cookie button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/div[1]/div/div/div/div/div/button")));
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div/div/div/div/button")).click();
        Thread.sleep(1000); // wait second to accept cookie
    }
}

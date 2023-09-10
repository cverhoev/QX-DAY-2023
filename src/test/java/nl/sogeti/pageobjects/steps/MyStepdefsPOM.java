package nl.sogeti.pageobjects.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nl.sogeti.data.model.Income;
import nl.sogeti.data.model.MonthlyCosts;
import nl.sogeti.pageobjects.calculator.CalculatorPage;
import nl.sogeti.pageobjects.StartPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MyStepdefsPOM {
    private static ChromeDriver driver;
    private static StartPage startPage;
    private static CalculatorPage calculatorPage;

    @Before
    public static void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        startPage = new StartPage(driver);
        calculatorPage = new CalculatorPage(driver);
    }

    @After
    public static void closeBrowser() {
        driver.quit();
    }

    @Given("^user is on start page")
    public void userIsOnStartPage() throws InterruptedException {
        startPage.navigateToStartPage();
    }

    @When("he enters total mortgage amount of {int}")
    public void heEntersTotalMortgageAmountOf(int totalMortgageAmount) throws InterruptedException {
        startPage.enterMortgageTotalAmount(totalMortgageAmount);
        calculatorPage.mortgageAmountCalculatorStep.clickContinueBtn();
    }

    @When("^he enters income data")
    public void heEntersIncomeData(DataTable incomeTable) {
        List<Map<String, String>> rows = incomeTable.asMaps(String.class, String.class);
        rows.forEach(row -> {
            Income income = new Income(row.get("yearly_income"), row.get("age"), row.get("single"));
            calculatorPage.incomeCalculatorStep.enterIncomeData(income);
        });
    }

    @Then("^he should see monthly costs")
    public void heShouldSeeMonthlyCosts(DataTable monthlyCostsTable) {
        List<Map<String, String>> rows = monthlyCostsTable.asMaps(String.class, String.class);
        rows.forEach(row -> {
            MonthlyCosts monthlyCosts = new MonthlyCosts(row.get("bruto"), row.get("netto"));
            calculatorPage.resultCalculatorStep.assertMonthlyCosts(monthlyCosts);
        });
    }
}

package nl.sogeti.screenplay.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import nl.sogeti.TestData;
import nl.sogeti.screenplay.calculator.ResultCalculatorStepPage;
import nl.sogeti.screenplay.tasks.Calculate;
import nl.sogeti.screenplay.tasks.Start;
import org.junit.After;
import org.junit.Assert;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
//import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
//import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class MyStepDefsScreenplay {
    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void tearDown() {
        OnStage.stage().drawTheCurtain();
    }

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Given("{actor} starts hypotheker calculator")
    public void startsHypothekerCalculator(Actor actor) {
        actor.remember("myData", new TestData("50000", "45", true));
        actor.attemptsTo(Start.hypothekerCalculator());
    }

    @When("{actor} calculates monthly mortgage costs for {int} mortgage")
    public void calculatesMonthlyMortgageCosts(Actor actor, int totalMortgageAmount) {
        actor.attemptsTo(Calculate.monthlyCosts(totalMortgageAmount));
    }

    @Then("{actor} sees monthly costs")
    public void seesMonthlyCosts(Actor actor, DataTable expectedCosts) {
        Map<String, String> row = expectedCosts.entries().get(0);

        assertEquals(row.get("gross"), actor.asksFor(Text.of(ResultCalculatorStepPage.monthlyGrossCosts)));
        assertEquals(row.get("netto"), actor.asksFor(Text.of(ResultCalculatorStepPage.monthlyNettoCosts)));

        actor.should(seeThat(WebElementQuestion.the(ResultCalculatorStepPage.monthlyGrossCosts),
                                WebElementStateMatchers.hasValue(row.get("gross"))));
        actor.should(seeThat(WebElementQuestion.the(ResultCalculatorStepPage.monthlyNettoCosts),
                                WebElementStateMatchers.hasValue(row.get("netto"))));


        actor.attemptsTo(Ensure.that(Text.of(ResultCalculatorStepPage.monthlyGrossCosts)).isEqualTo(row.get("gross")));
        actor.attemptsTo(Ensure.that(Text.of(ResultCalculatorStepPage.monthlyNettoCosts)).isEqualTo(row.get("netto")));
    }
}

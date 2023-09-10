package nl.sogeti.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import nl.sogeti.screenplay.StartPage;
import nl.sogeti.screenplay.calculator.MortgageAmountCalculatorStepPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Calculate implements Task {
    public Calculate(int mortgageAmount) {
        this.totalMortgageAmount = mortgageAmount;
    }
    private int totalMortgageAmount;
    public static Calculate monthlyCosts(int totalMortgageAmount) {
        return instrumented(Calculate.class, totalMortgageAmount);
    }
    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Enter.theValue(String.valueOf(totalMortgageAmount)).into(StartPage.mortgageTotalAmount),
                Click.on(StartPage.calculate),
                Click.on(MortgageAmountCalculatorStepPage.continueing),
                IncomeStep.provideData()
        );
    }
}

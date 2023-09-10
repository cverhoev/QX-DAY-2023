package nl.sogeti.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import nl.sogeti.TestData;
import nl.sogeti.screenplay.calculator.IncomeCalculatorStepPage;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IncomeStep implements Task {

    public static IncomeStep provideData() {
        return instrumented(IncomeStep.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        TestData data = t.recall("myData");
        if (data.getBrutoIncome() != null) {
            t.attemptsTo(
                    Enter.theValue(data.getBrutoIncome()).into(IncomeCalculatorStepPage.brutoYearlyIncome)
            );
        }

        if (data.getAge() != null) {
            t.attemptsTo(
                    Enter.theValue(data.getAge()).into(IncomeCalculatorStepPage.age)
            );
        }

        if (data.isSingle()) {
            t.attemptsTo(Click.on(IncomeCalculatorStepPage.single));
        }
        t.attemptsTo(
                SendKeys.of("/n").into(IncomeCalculatorStepPage.continueing)
        );
    }
}

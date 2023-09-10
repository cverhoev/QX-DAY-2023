package nl.sogeti.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import nl.sogeti.screenplay.StartPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Start implements Task {
    static StartPage startPage;

    public static Start hypothekerCalculator() {
        return instrumented(Start.class);
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        t.attemptsTo(
                Open.browserOn().the(startPage),
                Click.on(StartPage.acceptAllCookiesButton).afterWaitingUntilPresent()
        );
    }
}

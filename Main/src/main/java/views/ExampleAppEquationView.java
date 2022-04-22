package views;
import controllers.Controller;

public class ExampleAppEquationView {

    public void startApp(String[] args) {
        Controller contr = new Controller(args);
        contr.getDecision(args);
    }
}
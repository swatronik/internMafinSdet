package views;
import controllers.Controller;

public class ExampleAppEquationView {

    public void startApp(String[] args) {
        Controller contr = new Controller();
        contr.run(args);
        String viewVariable = contr.getD();
//        System.out.println(viewVariable);
    }
}
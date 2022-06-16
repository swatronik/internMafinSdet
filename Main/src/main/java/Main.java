import jira.Jira;

import static jira.Jira.makeDevComplete;

public class Main {

    public static void main(String[] args) {
        Jira jira = new Jira();
        System.out.println(jira.getStatus());
        makeDevComplete(jira);
    }

}

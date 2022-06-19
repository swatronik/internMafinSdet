import pattern_State.JiraTask;
import pattern_State.ToDoJiraTask;

public class Main {

    public static void main(String[] args) {

        JiraTask jiraTask = new ToDoJiraTask();

        jiraTask = jiraTask.complete()
                .unDo()
                .complete()
                .complete()
                .complete()
                .complete();

        System.out.println(jiraTask.getClass());
    }
}

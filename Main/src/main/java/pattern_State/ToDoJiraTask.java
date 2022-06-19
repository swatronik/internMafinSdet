package pattern_State;

public class ToDoJiraTask implements JiraTask {
    @Override
    public JiraTask complete() {
        return new InProgressJiraTask();
    }

    @Override
    public JiraTask unDo() {
        System.out.println("to do, undo is not working");
        return this;
    }

    @Override
    public JiraTask delete() {
        return new DeletedJiraTask();
    }

    @Override
    public JiraTask draft() {
        return new DraftJiraTask();
    }
}

package pattern_State;

public class InProgressJiraTask implements JiraTask{
    @Override
    public JiraTask complete() {
        return new InDevJiraTask();
    }

    @Override
    public JiraTask unDo() {
        return new ToDoJiraTask();
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

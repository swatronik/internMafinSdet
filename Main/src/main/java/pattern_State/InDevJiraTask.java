package pattern_State;

public class InDevJiraTask implements JiraTask{

    @Override
    public JiraTask complete() {
        return new CopletedJiraTask();
    }

    @Override
    public JiraTask unDo() {
        return new InProgressJiraTask();
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

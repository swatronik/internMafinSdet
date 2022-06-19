package pattern_State;

public class DeletedJiraTask implements JiraTask{
    @Override
    public JiraTask complete() {
        return this;
    }

    @Override
    public JiraTask unDo() {
        return this;
    }

    @Override
    public JiraTask delete() {
        return this;
    }

    @Override
    public JiraTask draft() {
        return this;
    }
}

package pattern_State;

public class CopletedJiraTask implements JiraTask{
    @Override
    public JiraTask complete() {
        System.out.println("INFO: already Completed");
        return this;
    }

    @Override
    public JiraTask unDo() {
        return new InDevJiraTask();
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

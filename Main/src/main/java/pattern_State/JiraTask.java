package pattern_State;


/*
реализация паттерна состояние через интерфейс
*/

public interface JiraTask {

    public JiraTask complete();
    public JiraTask unDo();
    public JiraTask delete();
    public JiraTask draft();
}

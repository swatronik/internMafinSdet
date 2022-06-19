package pattern_State.badExample;

/*
Задача: попробовать реализовать флоу Jira таски. Эмулировать работу кнопки со сменой состояния.

Плохой пример
На неправильном примере видим что:
1. Сложно расширять
2. Много делать изменений
3. Сложно поддерживать
*/

public class JiraButton {

    private String statusJiraButton;

    private String toDo = "to do";
    private String inProgress = "in progress";
    private String devComplete = "Dev complete";
    private String completed = "Completed";

    public String getStatusJiraButton() {
        return statusJiraButton;
    }

    public JiraButton() {
        this.statusJiraButton = toDo;
    }

    public void makeToDo(JiraButton task) {
        if (task.statusJiraButton != toDo | task.statusJiraButton == toDo) {
            task.statusJiraButton = toDo;
            System.out.println(toDo);
        } else if (task.statusJiraButton == toDo) {
            System.out.println("already" + toDo);
        } else if (task.statusJiraButton == completed)
            System.out.println("task is" + completed);
    }

    public void makeInProgress(JiraButton task) {
        if (task.statusJiraButton != inProgress) {
            task.statusJiraButton = inProgress;
            System.out.println(inProgress);
        } else if (task.statusJiraButton == inProgress) {
            System.out.println("already" + inProgress);
        } else if (task.statusJiraButton == completed)
            System.out.println("task is" + completed);
    }

    public void makeDevComplete(JiraButton task) {
        if (task.statusJiraButton != devComplete) {
            task.statusJiraButton = devComplete;
            System.out.println(devComplete);
        } else if (task.statusJiraButton == devComplete) {
            System.out.println("already" + devComplete);
        } else if (task.statusJiraButton == completed)
            System.out.println("task is" + completed);
    }

    public void makeCompleted(JiraButton task) {
        if (task.statusJiraButton != completed) {
            task.statusJiraButton = completed;
            System.out.println(completed);
        } else if (task.statusJiraButton == completed)
            System.out.println("already" + completed);
    }

}

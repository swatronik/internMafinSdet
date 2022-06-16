public class Jira {
    private String status;

    public String getStatus() {
        return status;
    }

    public Jira() {
        this.status = "To do";
    }

    public static void makeToDo(Jira task) {
        if (task.status == "To do") {
            System.out.println("Already to do");
        } else
            System.out.println("Impossible to move in to do");
    }

    public static void makeInProgress(Jira task) {
        if (task.status == "To do") {
            task.status = "In progress";
        } else System.out.println("Impossible to move in Completed, it's possible only for To do state");

    }

    public static void makeDevComplete(Jira task) {
        if (task.status == "In progress") {
            task.status = "Dev complete";
        } else System.out.println("Impossible to move in Dev complete, it's possible only for In progress state");
    }

    public static void makeCompleted(Jira task) {
        if (task.status == "Dev complete") {
            task.status = "Completed";
        } else System.out.println("Impossible to move in Completed, it's possible only for Dev complete state");

    }
}


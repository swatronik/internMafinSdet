package ConnectionDB.entity;

public class DataRowList {

    public Integer number;
    public String equation;
    public String roots;
    public String date;

    public DataRowList(Integer number, String equation, String roots, String date) {
        this.number = number;
        this.equation = equation;
        this.roots = roots;
        this.date = date;
    }

    public DataRowList() {
    }
}

package ConnectionDB.entity;

public class DataRowList {

    private Integer number;
    private String equation;
    private String roots;
    private String date;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getRoots() {
        return roots;
    }

    public void setRoots(String roots) {
        this.roots = roots;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DataRowList(Integer number, String equation, String roots, String date) {
        this.number = number;
        this.equation = equation;
        this.roots = roots;
        this.date = date;
    }

    public DataRowList() {
    }
}